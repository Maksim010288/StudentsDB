package simple.com.presentation.ui;

import simple.com.dal.SQLConnectionFactory;
import simple.com.dal.StudentRepository;
import simple.com.dal.entity.Student;
import simple.com.service.StudentService;
import simple.com.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RecordingInfoDB extends JFrame{

    public static JLabel labelLastName, labelFirstName, labelCourse;
    public static JTextField fieldId, fieldLastName, fieldFirstName, fieldCourse;
    JButton buttonSave;

    Font font = new Font("SentSarif", Font.ITALIC, 18);
    JPanel panelInput = new JPanel();
    RecordingInfoDB() throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.setTitle("Window");
        this.setSize(500, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(500, 0);
        labelFirstName = new JLabel("Введите имя:");
        labelLastName = new JLabel("Введите фамилию:");
        labelCourse = new JLabel("Введите курс:");
        fieldLastName = new JTextField(15);
        fieldFirstName = new JTextField(15);
        fieldCourse = new JTextField(2);
        buttonSave = new JButton("Записати");

        labelFirstName.setFont(font);
        labelLastName.setFont(font);
        labelCourse.setFont(font);
        fieldLastName.setForeground(Color.blue);
        fieldFirstName.setForeground(Color.blue);
        fieldCourse.setForeground(Color.blue);
        fieldLastName.setFont(font);
        fieldFirstName.setFont(font);
        fieldCourse.setFont(font);

        GridLayout gridLayout = new GridLayout(10, 2);
        FlowLayout flowLayout = new FlowLayout();
        panelInput.setLayout(gridLayout);
        buttonSave.setLayout(flowLayout);

        panelInput.add(labelFirstName);
        panelInput.add(fieldLastName);
        panelInput.add(labelLastName);
        panelInput.add(fieldFirstName);
        panelInput.add(labelCourse);
        panelInput.add(fieldCourse);
        panelInput.add(buttonSave);
        this.add(panelInput);

        panelInput.setVisible(true);
        this.setVisible(true);

        InputREcordInfoDB inputREcordInfoDB = new InputREcordInfoDB();
        buttonSave.addActionListener(inputREcordInfoDB);
    }

    class InputREcordInfoDB implements ActionListener{
        StudentService studentService = new StudentService();

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = new Student(fieldLastName.getText(),
                    fieldFirstName.getText(), fieldCourse.getText());
            if (e.getSource() == buttonSave) {
                try {
                    studentService.createStudent(student);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                fieldLastName.setText(null);
                   fieldFirstName.setText(null);
                   fieldCourse.setText(null);
                }
            }
        }
    }
