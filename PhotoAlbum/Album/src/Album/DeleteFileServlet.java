package Album;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by fengzipei on 12/19/15.
 */
public class DeleteFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String filename = request.getParameter("filename");
        File toBeDelete = new File(filename);
        toBeDelete.delete();
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.println(filename + " deleted successfully<br>");
            printWriter.println(request.getParameter("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("album", request.getParameter("album"));
        try {
            request.getRequestDispatcher("MyAlbum.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //request.setAttribute("username", );
    }
}
