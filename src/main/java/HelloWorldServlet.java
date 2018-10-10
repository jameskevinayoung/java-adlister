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

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")

public class HelloWorldServlet extends HttpServlet {
    //step 5: create a counter to count page views
    private int pageViewCount;

    public void init() {
        // Reset counter.
        pageViewCount = 0;
    }

    //Step 4: Create a page that displays "Hello World!" when a user visits /hello
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {



        res.setContentType("text/html");
        //add the page view counter after setting the response type and in the out.println
        pageViewCount++;


        //Add "throws ServletException and IOException" to doGet() to remove .getWriter() error
        PrintWriter out = res.getWriter();
        out.println("<h1>Hello, World!</h1>\n" + "<h2> Page views: "+pageViewCount+"</h2>\n");


    }
}
