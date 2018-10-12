package Student;

import java.util.ArrayList;

public class DaoFactory {
    //create an Object variable to hold the data access objects
    private static Students studentsDAO;

    //create a method to get the object variable;
    public static Students getStudentDAO() {

    //if the variable doesn't exist create a new list (ListStudentsDao) and return the studentsDao

        if(studentsDAO == null){
            studentsDAO = new ListStudentsDao();
        }
        return studentsDAO;
    }
}
