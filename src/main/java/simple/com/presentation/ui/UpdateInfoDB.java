package simple.com.presentation.ui;

import simple.com.service.StudentService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class UpdateInfoDB extends JFrame {
    public static JLabel labelNameTable, labelChangeName, labelEnterName, labelEnterNumberString;
    public static JTextField fieldNameTable, fieldChangeName, fieldEnterName, fieldEnterNumberString;
    private final JButton buttonUpdate;
    ButtonUpdateInformation buttonUpdateInformation = new ButtonUpdateInformation();
    JLabel panelUpdate = new JLabel();

    public UpdateInfoDB() throws SQLException, ClassNotFoundException, FileNotFoundException {
        this.setTitle("Update information");
        this.setSize(500, 250);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.add(panelUpdate);
        this.setLocation(500, 0);

        labelNameTable = new JLabel("Введите назву таблицы");
        labelChangeName = new JLabel("Введите назву поля");
        labelEnterName = new JLabel("Введите имя");
        labelEnterNumberString = new JLabel("Введите номер строки для изменения");
        fieldNameTable = new JTextField(10);
        fieldChangeName = new JTextField(10);
        fieldEnterName = new JTextField(10);
        fieldEnterNumberString = new JTextField(5);
        buttonUpdate = new JButton("Переименовать");

        GridLayout layoutUpdate = new GridLayout(10, 1);
        panelUpdate.setLayout(layoutUpdate);
        panelUpdate.add(labelNameTable);
        panelUpdate.add(fieldNameTable);
        panelUpdate.add(labelChangeName);
        panelUpdate.add(fieldChangeName);
        panelUpdate.add(labelEnterName);
        panelUpdate.add(fieldEnterName);
        panelUpdate.add(labelEnterNumberString);
        panelUpdate.add(fieldEnterNumberString);
        panelUpdate.add(buttonUpdate);

        panelUpdate.setVisible(true);
        buttonUpdate.addActionListener(buttonUpdateInformation);
        this.setVisible(true);
    }

    private class ButtonUpdateInformation implements ActionListener{
        StudentService service = new StudentService();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonUpdate){
                try {
                   service.UpdateToElement(fieldChangeName.getText(),
                            fieldEnterName.getText(), fieldEnterNumberString.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                fieldChangeName.setText(null);
                fieldEnterName.setText(null);
                fieldEnterNumberString.setText(null);
            }
        }
    }
}

