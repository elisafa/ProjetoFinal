package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
     public Connection conexao = null;
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DB = "BD_STBP";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName="+DB+";";
    private final String USER = "sa";
    private final String PASSWORD = "senac";
    
    public boolean getConexao() {
        try {
        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        JOptionPane.showMessageDialog(null, "Conexão feita com sucesso");
        return true;
        } catch (ClassNotFoundException erro) {
        JOptionPane.showMessageDialog(null, "Drive não encontrado");
            
            return false;
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Banco de dados não encontrado");
            return false;
        }
    }
    
    public void fecharConexao() {
        
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Desconectado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar");
        }
    }
}
