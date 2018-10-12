package Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//annotate the web servlet and provide a url
@WebServlet(name="StudentsServlet", urlPatterns ="/student")
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Student> students = DaoFactory.getStudentDAO().findAll();

        response.setContentType("text/html");
        String html ="";

        for(Student s: students){
            System.out.println("s.g");
            System.out.println();
        }
    }



}
