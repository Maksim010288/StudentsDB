package simple.com.service;

import simple.com.dal.entity.Student;

import java.util.List;

public class StudentValidator {

    public boolean valid(List<Student> student) {
        if (student.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean valid (String fieldDelFrom, String fieldWhatToDel){
        if (fieldDelFrom.equals("") || fieldWhatToDel.equals("")){
            return false;
        }
        return true;
    }

    public boolean valid (String fieldColumn, String fieldNewName, String fieldId){
        if (fieldColumn.equals("") ||
                fieldNewName.equals("") || fieldId.equals("")) {
            System.out.println("Заповніть пусті поля");
            return false;
        }
        return true;
    }
}

