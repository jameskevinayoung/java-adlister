package Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//The Data Access Object handles interactions with the database.
//This implements the interface to actually access the data.
//This handles the list of students and allows the ability to display the entire list,
//or display students individually, or add a new student to the list.
public class ListStudentsDao implements Students {


//created a variable for the list of students that hasn't been initialized

    List<Student> students;

    //created a List constructor for a list of student objects that produces an array list
    public ListStudentsDao() {
        students = new ArrayList<>();
        students.add(new Student(1,"James", "Young", new Date("02/22/1984"),'M'));
        students.add(new Student(2,"Rachael", "Simmons", new Date("08/28/1987"),'F'));
        students.add(new Student(2,"Mitchel", "Ahmad-Pital", new Date("05/17/1980"),'M'));
        students.add(new Student(2,"Fer", "Martinez", new Date("03/21/1991"),'M'));
        students.add(new Student(2,"Fatima", "Perrelli", new Date("01/17/1988"),'F'));
    }

    //this is a method that takes the list of student objects and returns all of the students
    public List<Student> findAll(){
        return students;
    }

    //this is a method that finds a student by the unique id and subtracts 1 from the id number
    //to return the student object in that particular index
    public Student findOne(long id){

        return students.get((int)id -1);
    }

    //this is a method that adds a new student object to the list
    public void add(Student student){

        //look for the size of the students list and add 1
        student.setStudentID(students.size()+1);

        //take the student objects list and add the new student to the existing list
        students.add(student);
    }
}
