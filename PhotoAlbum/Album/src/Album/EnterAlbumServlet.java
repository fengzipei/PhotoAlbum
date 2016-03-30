package Album;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by fengzipei on 12/19/15.
 */
public class EnterAlbumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.print(request.getParameter("filename"));
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("album", request.getParameter("filename"));
            try {
                request.getRequestDispatcher("MyAlbum.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
