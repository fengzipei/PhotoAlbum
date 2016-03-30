package Album;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by fengzipei on 12/19/15.
 */
public class JumpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("username", request.getParameter("username"));
        try {
            request.getRequestDispatcher("Albums.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
