package simple.com.presentation.ui;

import simple.com.config.DBConfigDTO;
import simple.com.dal.StudentRepository;
import simple.com.dal.SQLConnectionFactory;
import simple.com.dal.entity.Student;
import simple.com.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DisplayingInfoDB extends JFrame {

    public static JTextArea textAreaSuccessfulOperationInformation;
    public JButton buttonSave, buttonOutEntireList, buttonUpdate, buttonDeleted;

    Font font = new Font("SentSarif", Font.ITALIC, 18);
    JPanel panelButton = new JPanel();
    JPanel panelOutput = new JPanel();

    public DisplayingInfoDB() throws SQLException, ClassNotFoundException, FileNotFoundException {

        this.setTitle("Window");
        this.setSize(500, 375);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textAreaSuccessfulOperationInformation = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textAreaSuccessfulOperationInformation);

        buttonSave = new JButton("Сохранить");
        buttonOutEntireList = new JButton("Вивести весь список");
        buttonUpdate = new JButton("Изменить");
        buttonDeleted = new JButton("Удалить");

        FlowLayout layoutOut = new FlowLayout();
        GridLayout layoutButton = new GridLayout(4, 4);

        panelOutput.setLayout(layoutOut);
        panelButton.setLayout(layoutButton);

        textAreaSuccessfulOperationInformation.setFont(font);
        textAreaSuccessfulOperationInformation.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        textAreaSuccessfulOperationInformation.setForeground(Color.blue);
        textAreaSuccessfulOperationInformation.setEditable(false);

        panelOutput.add(buttonSave);
        panelOutput.add(buttonOutEntireList);
        panelOutput.add(buttonUpdate);
        panelOutput.add(buttonDeleted);
        panelOutput.add(scrollPane);

        this.add(panelButton);
        this.add(panelOutput);

        panelOutput.setVisible(true);
        panelButton.setVisible(true);
        this.setVisible(true);

        InterfaceButtonControl interfaceButtonControl = new InterfaceButtonControl();
        buttonSave.addActionListener(interfaceButtonControl);
        buttonOutEntireList.addActionListener(interfaceButtonControl);
        buttonDeleted.addActionListener(interfaceButtonControl);
        buttonUpdate.addActionListener(interfaceButtonControl);
    }

    class InterfaceButtonControl implements ActionListener {
        StudentService studentService = new StudentService();
        StudentRepository repository;
        DBConfigDTO dbConfigDTO;

        {
            try {
                repository = new StudentRepository(new SQLConnectionFactory(dbConfigDTO).getDbConnection());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == buttonSave) {
                try {
                    new RecordingInfoDB();
                } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            if (e.getSource() == buttonOutEntireList) {
                textAreaSuccessfulOperationInformation.setText(null);
                try {
                    List<Student> stringList = studentService.getAllStudent();
                    for (Student s : stringList) {
                        textAreaSuccessfulOperationInformation.append(s.toString());
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

                if (e.getSource() == buttonDeleted) {
                    try {
                        new DeleteInfoDB();
                    } catch (SQLException | ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getSource() == buttonUpdate) {
                    try {
                        new UpdateInfoDB();
                    } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }