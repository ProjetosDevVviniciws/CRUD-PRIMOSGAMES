package locadoragames;

import BancoDeDados.DbConfig;
import java.sql.Connection; // Representa a conexão com banco de Dados.
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Traz um conjunto de resultados de uma consulta SQL, por exemplo: SELECT, INSERT, USE, DELETE, UPDATE, entre outos.
import java.sql.Statement; // Serve para passar os parametros SQL e até mesmo instruções para o banco de dados. 

public class Games {

    // BUSCAR TODOS GAMES

    public void buscarGames() {
        try {
            Connection connection = DbConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoragames.games");

            while (resultSet.next()) {
                System.out.println("\nId: " + resultSet.getInt("id"));
                System.out.println("Nome do Game: " + resultSet.getString("nome"));
                System.out.println("Categoria: " + resultSet.getString("categoria"));
                System.out.println("Ano de Lançamento: " + resultSet.getInt("ano_de_lancamento"));
                System.out.println("Status: " + resultSet.getBoolean("disponivel"));
                System.out.println("Imagem do Game: " + resultSet.getString("url_game"));
                System.out.println("Preço por dia: " + resultSet.getDouble("preco_por_dia"));
            }
            // USADO PARA FECHAR A CONEXÃO.
            connection.close();
            System.out.println("Busca feita com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADICIONAR UM NOVO GAME

    public void adicionarGames(String nome, String categoria, int ano_de_lancamento, boolean disponivel, String url_game, double preco_por_dia) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "INSERT INTO locadoragames.games (nome, categoria, ano_de_lancamento, disponivel, url_game, preco_por_dia)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, categoria);
            preparedStatement.setInt(3, ano_de_lancamento);
            preparedStatement.setBoolean(4, disponivel);
            preparedStatement.setString(5, url_game);
            preparedStatement.setDouble(6, preco_por_dia);

            connection.close();
            System.out.println("Game adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ATUALIZAR UM GAME

    public void atualizarGames(int id, String nome, String categoria, int ano_de_lancamento, boolean disponivel, String url_game, double preco_por_dia) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "UPDATE INTO locadoragames.games SET nome = ?, categoria = ?, ano_de_lancamento = ?, disponivel = ?, url_game = ?, preco_por_dia = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, categoria);
            preparedStatement.setInt(4, ano_de_lancamento);
            preparedStatement.setBoolean(5, disponivel);
            preparedStatement.setString(6, url_game);
            preparedStatement.setDouble(7, preco_por_dia);

            connection.close();
            System.out.println("Game atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETAR UM GAME

    public void removerGames(int id) {
        try {
            Connection connection = DbConfig.getConnection();
            String sql = "DELETE FROM locadoragames.games WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Game deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
