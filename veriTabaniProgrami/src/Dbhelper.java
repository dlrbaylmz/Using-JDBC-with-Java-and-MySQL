import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbhelper {
    private String userName= "newuser";
    private String password="12345Sql";
    private String dbUrl="jdbc:mysql://localhost:3306/world?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error code : " + exception.getErrorCode());
    }
}
