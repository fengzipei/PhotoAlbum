package Album;

import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 * Created by fengzipei on 12/18/15.
 */
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        pw.write(username + "<br>");
        pw.write(password + "<br>");
        try {
            String query = "SELECT username, password FROM account WHERE username = ?";
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "F");
            pw.write(!connection.isClosed()? "connected to Database<br>" : "failed to connect to Database<br>");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                pw.write("account have already exists<br>");
            } else {
                pw.write("inserting<br>");
                String insertSql = "INSERT INTO account(username, password, path) VALUES (?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertSql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, "../webapps/file/" + username);
                pw.write(preparedStatement.executeUpdate());
                String directoryName = "./" + username;
                File newDirectory = new File("../webapps/file/" + directoryName);
                newDirectory.mkdirs();
                pw.println("new account " + username + "successfully<br>");
                response.sendRedirect("/Album_war/index.jsp");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pw.close();

        }
    }
}
