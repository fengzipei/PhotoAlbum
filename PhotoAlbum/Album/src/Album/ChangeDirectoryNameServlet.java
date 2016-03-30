package Album;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by fengzipei on 12/19/15.
 */
public class ChangeDirectoryNameServlet extends HttpServlet {
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
            String oldDirectory = request.getParameter("filename");
            String newDirectory = request.getParameter("newname");
            File old = new File(oldDirectory);
            File neww = new File(old.getParentFile() + File.separator + newDirectory);
            old.renameTo(neww);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
