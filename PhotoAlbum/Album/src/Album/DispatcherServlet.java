package Album;

/**
 * Created by fengzipei on 12/17/15.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        pw.write(username + "<br>");
        pw.write(password + "<br>");
        String query = "SELECT username, password FROM account WHERE username = ?";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "F");
            pw.write(!conn.isClosed()? "connected to Database<br>" : "failed to connect to Database<br>");
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            String p = null;
            if(!resultSet.next()){
                pw.write("account not exists<br>");
            } else {
                p = resultSet.getString("password");
            }
            if (p.equals(password)) {
                pw.write("login successfully<br>");
                request.setAttribute("username", username);
                request.getRequestDispatcher("Albums.jsp").forward(request,response);
            } else {
                pw.write("wrong password<br>");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }
}
