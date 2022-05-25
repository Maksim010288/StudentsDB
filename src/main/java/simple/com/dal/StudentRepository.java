package simple.com.dal;

import simple.com.dal.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    final Connection dbconnection;

    public StudentRepository(Connection dbconnection) {
        this.dbconnection = dbconnection;
    }

    public void create(Student student) throws SQLException {
        String create = String.format("INSERT INTO %s(%s, %s, %s) VALUES(?, ?, ?);",
                Student.DbStudentsConstants.TABLE_STUDENT,
                Student.DbStudentsConstants.STUDENT_LASTNAME,
                Student.DbStudentsConstants.STUDENT_FIRSTNAME,
                Student.DbStudentsConstants.STUDENT_COURSE);
        System.out.println(create);

        PreparedStatement preparedStatement = dbconnection.prepareStatement(create);
        preparedStatement.setString(1, student.getLastName());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getGrade());
        preparedStatement.execute();
    }

    public List<Student> findAll() throws SQLException {
        String read = String.format("SELECT * FROM %s;", Student.DbStudentsConstants.TABLE_STUDENT);
        Statement statement = dbconnection.createStatement();
        ResultSet resultSet = statement.executeQuery(read);
        List<Student> result = new ArrayList<>();

        while (resultSet.next()) {
            int outId = resultSet.getInt(1);
            String outLastName = resultSet.getString(2);
            String outFirstName = resultSet.getString(3);
            String outCourse = resultSet.getString(4);
            Student student = new Student(outId, outFirstName, outLastName, outCourse);
            result.add(student);
            System.out.print(student);
        }
        return result;
    }

    public void remove(String deleteFrom, String deleteWhere)
            throws SQLException {
        String delete = String.format("DELETE FROM students WHERE %s = ?;",
                deleteFrom);
        PreparedStatement prepareStatement = dbconnection.prepareStatement(delete);
        prepareStatement.setString(1, deleteWhere);
        prepareStatement.executeUpdate();
        prepareStatement.close();
    }

    public void upDateStudent(String changeName, String forName, String id) throws SQLException {
        String update = String.format("update students set %s = ? where id = ?;",
                changeName);
        PreparedStatement prepareStatement = dbconnection.prepareStatement(update);
        prepareStatement.setString(1, forName);
        prepareStatement.setString(2, id);
        prepareStatement.executeUpdate();
    }
}
