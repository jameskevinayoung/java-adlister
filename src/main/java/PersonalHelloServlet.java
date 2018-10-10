import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;


/**
 * Step 1: Fork and clone the Adlister Repository
 *
 * Step 2: Checkout the servlets tag and branch off of it
 *
 * Step 3: Configure IntelliJ for the project
 */

@WebServlet(name = "PersonalHelloServlet", urlPatterns = "/form")
public class PersonalHelloServlet extends HttpServlet {
    //step 5: create a counter to count page views
    private int pageViewCount; //create a counter property that is private

    //create an initializer that will reset counter
    public void init() {
        // Reset counter.
        pageViewCount = 0;
    }

    //Step 4: Create a page that displays "Hello World!" when a user visits /hello
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        res.setContentType("text/html");
        //add the page view counter after setting the response type and in the out.println
        pageViewCount++;//increment the counter


        //Add "throws ServletException and IOException" to doGet() to remove .getWriter() error
        PrintWriter out = res.getWriter();

        //on the doGet method, create a form

        out.println("<form method=post>" ); //create a form where the method is post inorder to use it in the doPost
        out.println("What is your name?"); //this form will
        out.println("<INPUT TYPE=TEXT NAME='name'><P>");
        out.println("<INPUT TYPE=SUBMIT>");
        out.println("</form>");





    }
    public String getServletInfo() {
        return "A servlet that knows the name of the person to whom it's" +
                "saying hello";
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {



        res.setContentType("text/html");
        //add the page view counter after setting the response type and in the out.println
        pageViewCount++;
        String name = req.getParameter("name");

        //Add "throws IOException" to doGet() to remove .getWriter() error
        PrintWriter out = res.getWriter();

        out.println("<h1>Hello, "+ name +"!</h1>\n" + "<h2> Page views: "+pageViewCount+"</h2>\n");


    }


}