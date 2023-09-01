import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = null;

        connection = databaseConnection.StartConnection(connection); // — > Cria a conexão

        System.out.println("Connection created: " + connection);
        System.out.println();

        DatabaseUtil dbUtil = new DatabaseUtil(connection); // — > Passa a conexão para a DatabaseUtil

        //SELECT========================================================================================================
        //String nomeSelect = "Rafael";
        //String selectQuery = "SELECT * FROM Paciente WHERE nome = '" + nomeSelect + "'";
        String selectQuery = "SELECT * FROM Paciente ORDER BY id";
        dbUtil.realizaSelect(selectQuery);

        //==============================================================================================================
//        id NUMBER PRIMARY KEY NOT NULL,
//        nome VARCHAR2(100) NOT NULL,
//        dt_nasc DATE NOT NULL,
//        genero VARCHAR2(1) NOT NULL,
//        endereco VARCHAR2(100) NOT NULL,
//        cidade VARCHAR2(50) NOT NULL,
//        telefone NUMBER(11),
//                upa VARCHAR2(100) NOT NULL);


        //INSERT========================================================================================================
//        String nomeInsert = "João";
//        String data = "01/01/2001";
//        char genero = 'M';
//        long numero = 44996385274L;
//        String query = "INSERT INTO Paciente VALUES(s_contadorId.nextval, '"+ nomeInsert +"', TO_DATE('"+ data +"', 'DD/MM/YYYY'), " +
//                       "'"+ genero +"', 'Rua Interventor Manoel Ribas, 56', 'Mandaguari',"+ numero +", 'Centro')";
//
//        dbUtil.realizaInsert(connection, query);

//        String nomeInsert = "Joana";
//        String data = "01/02/2004";
//        char genero = 'F';
//        long numero = 44965274637L;
//        String query = "INSERT INTO Paciente VALUES(s_contadorId.nextval, '"+ nomeInsert +"', TO_DATE('"+ data +"', 'DD/MM/YYYY'), " +
//                       "'"+ genero +"', 'Rua Pombinhas, 34', 'Maringá',"+ numero +", 'Zona Norte')";
//
//        dbUtil.realizaInsert(connection, query);

//        String nomeInsert = "Pedro";
//        String data = "01/10/1998";
//        char genero = 'M';
//        long numero = 44999120488L;
//        String query = "INSERT INTO Paciente VALUES(s_contadorId.nextval, '"+ nomeInsert +"', TO_DATE('"+ data +"', 'DD/MM/YYYY'), " +
//                       "'"+ genero +"', 'Rua Interventor Manoel Ribas, 56', 'Mandaguari',"+ numero +", 'Centro')";
//
//        dbUtil.realizaInsert(connection, query);
        //==============================================================================================================


        //UPDATE========================================================================================================
//        String nomeUpdate = "Polyana";
//        int id = 3;
//        // UPDATE Paciente SET nome = 'Maria' WHERE id = 3;
//        String query = "UPDATE Paciente SET nome = '"+ nomeUpdate+"' WHERE id = "+ id;
//
//        dbUtil.realizaUpdate(connection, query);

//        String enderecoUpdate = "Rua Padre José, 78";
//        int id = 4;
//        // UPDATE Paciente SET nome = 'Maria' WHERE id = 3;
//        String query = "UPDATE Paciente SET endereco = '"+ enderecoUpdate+"' WHERE id = "+ id;
//
//        dbUtil.realizaUpdate(connection, query);

        //==============================================================================================================

        System.out.println();
        databaseConnection.CloseConnection(connection); // — > Fechar conexão


    }
}