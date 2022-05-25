package simple.com.dal.entity;

import java.sql.Blob;

public class Student {

    private int id;
    private String lastName;
    private String firstName;
    private String grade;
    private Blob blobFoto;

    public Student(int id, String lastName, String firstName, String grade) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
    }

    public Student(String lastName, String firstName, String grade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getBlobFoto() {
        return blobFoto;
    }

    public void setBlobFoto(Blob blobFoto) {
        this.blobFoto = blobFoto;
    }

    @Override
    public String toString() {
        return id + " " + lastName + " " + firstName + " " + grade + "\n";
    }

   public static class DbStudentsConstants {
        public static final String TABLE_STUDENT = "students";
        public static final String STUDENT_FIRSTNAME = "first_name";
        public static final String STUDENT_LASTNAME = "last_name";
        public static final String STUDENT_COURSE = "course";
        public static final String STUDENT_FOTO = "foto";
    }
}

