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
        String query;

        int opcao = 0;
        int opcaoSelect = 0;

        opcao = Integer.parseInt(JOptionPane.showInputDialog("0 - SAIR\n1 - SELECT\n2 - INSERT"));

        do{
            switch (opcao) {
                case 1:
                    opcaoSelect = Integer.parseInt(JOptionPane.showInputDialog("1 - FULL\n2 - POR NOME\n3 - VOLTAR"));
                    if (opcaoSelect == 1){
                        dbUtil.realizaSelect("SELECT * FROM Paciente ORDER BY id");
                        break;
                    } else if (opcaoSelect == 2){
                        String nome = JOptionPane.showInputDialog("Nome para busca: ");
                        dbUtil.realizaSelect("SELECT * FROM Paciente WHERE nome LIKE '" + nome + "'");
                        break;
                    } else {
                        opcao = Integer.parseInt(JOptionPane.showInputDialog("0 - SAIR\n1 - SELECT\n2 - INSERT"));
                    }
                    break;
                case 2:
                    int id = dbUtil.realizaSelect("SELECT * FROM Paciente").size() + 1;
                    String nome = JOptionPane.showInputDialog("Insira o nome: ");
                    String dt_nasc = JOptionPane.showInputDialog("Insira a data (dia/mes/ano): ");
                    String genero = JOptionPane.showInputDialog("Insira o genero (M/F): ");
                    String endereco = JOptionPane.showInputDialog("Insira o endereço: ");
                    String cidade = JOptionPane.showInputDialog("Insira a cidade: ");
                    long telefone = Long.parseLong(JOptionPane.showInputDialog("Insira o telefone: "));
                    String ubs = JOptionPane.showInputDialog("Insira a UBS: ");

                    dbUtil.realizaInsert(connection, "INSERT INTO Paciente (id, nome, dt_nasc, genero, endereco, cidade, telefone, ubs)" +
                            " VALUES ("+id+","+nome+","+dt_nasc+","+genero+","+endereco+","+cidade+","+telefone+","+ubs+")");
                    break;
                default:
                    if (opcao != 0)
                        JOptionPane.showMessageDialog(null,"Opção inválida.\n");
            }
        }while(opcao != 0);

        System.out.println();
        databaseConnection.CloseConnection(connection); // — > Fechar conexão


    }
}