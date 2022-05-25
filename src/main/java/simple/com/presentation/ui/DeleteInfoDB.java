package simple.com.presentation.ui;

import simple.com.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteInfoDB extends JFrame {

    public static JTextField fieldDeleteFrom, fieldWhatToDelete;
    public static JLabel labelDeleteFrom, labelWhatToDelete, labelInfoEboutDelete;
    public JButton buttonDeletedList;
    JPanel panelDelete = new JPanel();

    DeleteInfoDB() throws SQLException, ClassNotFoundException, IOException {
        this.setTitle("Delete window");
        this.setSize(500, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 0);

        labelDeleteFrom = new JLabel("Введите назву столбца базы даных");
        labelWhatToDelete = new JLabel("Введите назву");
        fieldDeleteFrom = new JTextField(15);
        fieldWhatToDelete = new JTextField(15);
        buttonDeletedList = new JButton("Удалить список");
        labelInfoEboutDelete = new JLabel();

        GridLayout layoutDelete = new GridLayout(10, 1);
        panelDelete.setLayout(layoutDelete);

        this.add(panelDelete);
        panelDelete.add(labelDeleteFrom);
        panelDelete.add(fieldDeleteFrom);
        panelDelete.add(labelWhatToDelete);
        panelDelete.add(fieldWhatToDelete);
        panelDelete.add(buttonDeletedList);
        panelDelete.add(labelInfoEboutDelete);

        panelDelete.setVisible(true);
        this.setVisible(true);

        InterfaceButtonDelete interfaceButtonDelete = new InterfaceButtonDelete();
        buttonDeletedList.addActionListener(interfaceButtonDelete);
    }

    class InterfaceButtonDelete implements ActionListener {
        StudentService service = new StudentService();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonDeletedList) {
                try {
                    service.deleteToElement(fieldDeleteFrom.getText(), fieldWhatToDelete.getText());
                    fieldDeleteFrom.setText(null);
                    fieldWhatToDelete.setText(null);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
