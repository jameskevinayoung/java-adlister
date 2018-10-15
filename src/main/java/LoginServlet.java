import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //create string objects for the username and password that holds the requested info;
        //get the parameter username and password for each string object

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //to see if the user is the appropriate one for the profile, set up a test for a valid login attempt;
        //create a boolean variable to is assigned to a username and password;

        boolean validAttempt = username.equals("admin") && password.equals("password");

        //in order to use the user's name later we have to get the session cookies and set the username to the username object

        request.getSession().setAttribute("username", username);

        //use conditionals to determine what information is going where

        if (validAttempt) {
            //if the username and password matches the acceptable username/password of the admin;
            //get a session and set the attribute key as user as true

            request.getSession().setAttribute("user", true);

            //redirect the user to the admin profile

            response.sendRedirect("/profile");
        } else {

            //otherwise redirect them back to the login page

            response.sendRedirect("/login");
        }





    }
}
