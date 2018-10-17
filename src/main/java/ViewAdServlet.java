import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

//One servlet per specific action


    /*
    1) retrieve the id column of the ads from the request and if it is does not exist get the list of ads from the Dao Factory
    2) set the attribute of the request to a string ("what ever you want to call it") and an object (the actual object name)
    3) forward the request and response to the appropriate web page using the getRequestDispatcher


    4) otherwise(else) get the id column of the request (which is a long integer)
    */
        if(req.getParameter("id") == null){
            List<Ad> ads = DaoFactory.getAdsDao().all(); // 1.
            req.setAttribute("ads", ads); // 2.
            req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req,res); // 3.
        } else{
            //the parameter is a string and will not return unless you cast it as a long integer

//            long id = Long.parseLong(req.getParameter("id")); // 4.
//            req.setAttribute("ad", DaoFactory.getAdsDao().findOne(id));
//            request.getRequestDispatcher("WEB-INF/ads/show.jsp").forward(request, response);

        }


    }




}
