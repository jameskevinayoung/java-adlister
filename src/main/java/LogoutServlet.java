import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//when someone visits a page that is a get request
@WebServlet(name="LogoutServlet", urlPatterns ="/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //when the user logs out we want to delete the session;
        //then redirect the user to the login page
        request.getSession().invalidate();
        request.getRequestDispatcher("/login").forward(request, response);



    }


}
