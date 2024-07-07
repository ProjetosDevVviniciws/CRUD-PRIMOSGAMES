package locadoragames;

import BancoDeDados.DbConfig;
import java.sql.Connection; // Representa a conexão com banco de Dados.
import java.sql.PreparedStatement; 
import java.sql.ResultSet; // Traz um conjunto de resultados de uma consulta SQL, por exemplo: SELECT, INSERT, USE, DELETE, UPDATE, entre outos.
import java.sql.Statement; // Serve para passar os parametros SQL e até mesmo instruções para o banco de dados. 

public class Precos {

    // BUSCAR TODOS OS PREÇOS

    public void buscarPrecos() {
        try {
            Connection connection = DbConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoragames.precos");

            while (resultSet.next()) {
                System.out.println("\nID: " + resultSet.getInt("id"));
                System.out.println("Categoria: " + resultSet.getString("categoria"));
                System.out.println("Preço por dia: " + resultSet.getDouble("preco_por_dia"));
            }
            // USADO PARA FECHAR A CONEXÃO.
            connection.close();
            System.out.println("Busca feita com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADICIONAR UM NOVO PREÇO

    public void adicionarPrecos(String categoria, double preco_por_dia) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "INSERT INTO locadoragames.precos (categoria, preco_por_dia) VALUES (?, ?)"; // O id não vai entrar aqui, pois ele será gerado automaticamente.
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoria);
            preparedStatement.setDouble(2, preco_por_dia);
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Preço criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ATUALIZAR UM PREÇO

    public void atualizarPrecos(int id, String categoria, double preco_por_dia) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "UPDATE INTO locadoragames.precos SET categoria = ?, preco_por_dia = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, categoria);
            preparedStatement.setDouble(3, preco_por_dia);
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Preço atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETAR UM PREÇO

    public void removerPrecos(int id) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "DELETE FROM locadoragames.precos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Preço deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
