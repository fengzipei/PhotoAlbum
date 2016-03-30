package Album;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by fengzipei on 12/20/15.
 */
public class ChangeFileNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String old = request.getParameter("filename");
        String neww = request.getParameter("newname");
        File oldFile = new File(old);
        File newFile = new File(oldFile.getParentFile() + File.separator + neww);
        oldFile.renameTo(newFile);
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("album", request.getParameter("album"));
        try {
            request.getRequestDispatcher("MyAlbum.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
