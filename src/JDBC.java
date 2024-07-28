import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bankk";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM nasabah";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {


            while (resultSet.next()) {
                System.out.println(resultSet.getString("nama_nasabah"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
