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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        request.getSession().setAttribute("username", username);

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
