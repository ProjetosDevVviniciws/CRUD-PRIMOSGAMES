package locadoragames;

import BancoDeDados.DbConfig;
import java.sql.Connection; // Representa a conexão com banco de Dados.
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Traz um conjunto de resultados de uma consulta SQL, por exemplo: SELECT, INSERT, USE, DELETE, UPDATE, entre outos.
import java.sql.Statement; // Serve para passar os parametros SQL e até mesmo instruções para o banco de dados. 

public class Clientes {

    // BUSCAR TODOS OS CLIENTES

    public void buscarClientes() {
        try {
            Connection connection = DbConfig.getConnection(); // Serve para tentar uma conexão.
            Statement statement = connection.createStatement(); // Serve para criar uma sentença SQL em Java.
            ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoragames.clientes"); 
            

            while (resultSet.next()) {
                System.out.println("\nId: " + resultSet.getInt("id"));
                System.out.println("Nome: " + resultSet.getString("nome"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("CPF: " + resultSet.getString("cpf"));
            }
            // USADO PARA FECHAR A CONEXÃO.
            connection.close();
            System.out.println("Busca feita com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CADASTRA UM NOVO CLIENTE

    public void adicionarClientes(String nome, String email, String cpf) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "INSERT INTO locadoragames.clientes (nome, email, cpf) VALUE (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, cpf);
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Cliente criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ATUALIZAR UM CLIENTE

    public void atualizarClientes(int id, String nome, String email, String cpf) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "UPDATE INTO locadoragames.clientes SET nome = ?, email = ?, cpf = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, cpf);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            
            connection.close();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETAR UM CLIENTE
    
    public void removerClientes(int id) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "DELETE FROM locadoragames.clientes WHERE id = ?"; 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Cliente deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
