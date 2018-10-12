import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//create a servlet attached to the index
//this sets up the link of the webpage to the /ads url


@WebServlet(name="IndexServlet", urlPatterns="/ads")
public class IndexServlet extends HttpServlet {

//create a doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//set the attribute for the ads by getting a list of ads from DaoFactory which pulls from the ListAdsDao class;

        request.setAttribute("ads", DaoFactory.getAdsDao());
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);


    }
}
