package Student;
//create the blueprint of what your object will look like

import java.util.Date;

public class Student {
    //create the properties for the object
    private long studentID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;

    //an empty constructor allows you to register an object without any parameters
    public Student() {

    }

    //a constructor with all properties allows you to read an object that is already registered

    public Student(String firstName, String lastName, Date dateOfBirth, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public long getStudentID(){
        return studentID;
    }

    public void setStudentID(long studentID){
        this.studentID= studentID;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }




}
