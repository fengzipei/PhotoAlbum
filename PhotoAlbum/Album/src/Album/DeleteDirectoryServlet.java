package Album;

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
public class DeleteDirectoryServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String filename = request.getParameter("filename");
        try {
            PrintWriter printWriter = response.getWriter();
            deleteDirectory(filename);
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

    public void deleteDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (directory.isFile()) {
            directory.delete();
        } else if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();
            for (File file : fileList) {
                deleteDirectory(file.getAbsolutePath());
            }
            directory.delete();
        }
    }
}
