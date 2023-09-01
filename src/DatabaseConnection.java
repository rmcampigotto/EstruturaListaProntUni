import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    // cria a conexão
    public Connection StartConnection(Connection connection) throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        Properties props = new Properties();
        props.setProperty("user", "hr"); // Passa a propriedade usuário
        props.setProperty("password", "hr"); // Passa a propriedade senha

        return connection = DriverManager.getConnection(jdbcUrl, props);
    }

    // fecha a conexão
    public void CloseConnection(Connection connection) throws SQLException {
        connection.close(); // fecha a conexão

        System.out.println("Connection closed: " + connection);
    }

}
