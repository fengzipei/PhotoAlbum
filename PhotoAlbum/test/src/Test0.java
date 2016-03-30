import java.sql.*;


/**
 * Created by fengzipei on 12/18/15.
 */
public class Test0 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "F");
        String insertSql = "INSERT INTO account(username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, "test0");
        preparedStatement.setString(2, "F");
        preparedStatement.executeUpdate();
        String query = "SELECT username, password FROM account WHERE username = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "test");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("username") + " " + resultSet.getString("password"));
        }
        connection.close();
    }
}
