import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private Connection connection = null;

    public DatabaseUtil(Connection connection) {
        this.connection = connection;
    }

    // função de realizar select =======================================================================================
    public List<String[]> realizaSelect(String query) {
        List<String[]> results = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int columnCount = resultSet.getMetaData().getColumnCount(); // Obtendo o número de colunas

            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getString(i);
                }
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        // print
        for (String[] row : results) {
            for (String value : row) {
                System.out.print("| " + value + "\t");
            }
            System.out.println();
        }
        System.out.println();

        return results;

    }


    // função de realizar Insert =======================================================================================
    public void realizaInsert(Connection connection, String query){
        try {
            // Criar uma declaração
            Statement statement = connection.createStatement();

            // Executar a query INSERT
            int rowsAffected = statement.executeUpdate(query);

            // Fechar recursos
            statement.close();

            System.out.println(rowsAffected + " linhas inseridas com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e);
        }
    }

    // função de realizar Update =======================================================================================
    public void realizaUpdate(Connection connection, String query){
        try {
            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(query);

            statement.close();

            System.out.println(rowsAffected + " linhas alteradas com sucesso!");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // função de realizar Delete - Somente para nós que administramos o Banco de Dados =================================
    public void realizaDelete(Connection connection, String query){
        try {
            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(query);

            statement.close();

            System.out.println(rowsAffected + " linhas deletadas com sucesso!");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}