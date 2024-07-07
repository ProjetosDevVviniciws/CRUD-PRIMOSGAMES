
import java.sql.Connection; // Representa a conexão com banco de Dados.
import java.sql.ResultSet; // Traz um conjunto de resultados de uma consulta SQL, por exemplo: SELECT, INSERT, USE, DELETE, UPDATE, entre outos.
import java.sql.Statement; // Serve para passar os parametros SQL e até mesmo instruções para o banco de dados.
import BancoDeDados.DbConfig;

// É UTILIZADA PARA ENCAPSULAR AS OPERAÇÔES DO BANCO DE DADOS E FACILITA A INTERAÇÂO COM O MESMO.

public class DataBaseOperations {
    public DataBaseOperations() {
    }

    public void buscarClientes() {
        try {
            Connection connection = DbConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoragames.games");

            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id"));
                System.out.println("Nome " + resultSet.getString("nome"));
                System.out.println("Email " + resultSet.getString("email"));
                System.out.println("CPF " + resultSet.getString("cpf"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
