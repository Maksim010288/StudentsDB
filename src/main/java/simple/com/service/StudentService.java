package simple.com.service;

import simple.com.config.DBConfigDTO;
import simple.com.dal.SQLConnectionFactory;
import simple.com.dal.StudentRepository;
import simple.com.dal.entity.Student;
import simple.com.presentation.ui.DisplayingInfoDB;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    StudentRepository repository;
    DBConfigDTO dbConfigDTO;

    {
        try {
            repository = new StudentRepository(new SQLConnectionFactory(dbConfigDTO).getDbConnection());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    StudentValidator validator = new StudentValidator();
    CheckingAFieldForEmptiness checkingAFieldForEmptiness = new CheckingAFieldForEmptiness();

    public void createStudent( Student student) throws SQLException {
            repository.create(student);
        }

    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        List<Student> list = repository.findAll();
        if (validator.valid(list)){
            String outInfo = "в списку немає жодного запису";
            System.out.println(outInfo);
            DisplayingInfoDB.textAreaSuccessfulOperationInformation.setText(outInfo);
        }
        return list;
    }

    public void deleteToElement(String forDel, String whatDel) throws SQLException, ClassNotFoundException {
        if (validator.valid(forDel, whatDel)){
            repository.remove(forDel, whatDel);
            System.out.println("Запис видалено!!!");
        }
    }

    public void UpdateToElement(String columnField, String renameField, String fieldId) throws SQLException {
        if (validator.valid(columnField, renameField, fieldId)){
            repository.upDateStudent(columnField, renameField, fieldId);
            System.out.println("Запис було змінено");
        }
    }
}
