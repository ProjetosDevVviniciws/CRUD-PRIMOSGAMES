package BancoDeDados;

import java.sql.Connection; // Representa a conexão com banco de Dados.
import java.sql.DriverManager; // Gerencia um conjunto de drivers do banco de dados.
import java.sql.SQLException; // Trata erros relacionados ao banco de dados.

// SERVER PARA PASSAR OS PARÂMETROS/INFORMAÇÕES DE ACESSO DO USUÁRIO AO BANCO.

public class DbConfig {
    private static final String url = "jdbc:mysql://localhost:3306/locadoragames"; // (URL DO BANCO DE DADOS)
    private static final String user = "root"; // (USUÁRIO PARA O LOGIN)
    private static final String password = "Telefone225XX"; // (SENHA PARA O LOGIN)

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}