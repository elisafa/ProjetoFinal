package dao;

import static dao.AlunoDAO.conexaoBanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ConexaoDAO {
      static PreparedStatement statement = null;
    public Connection conexao = null;
    
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DB = "STBP";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName="+DB+";";
    private final String USER = "sa";
    private final String PASSWORD = "senac";
    
    public boolean getConexao() {
        try {
        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        //JOptionPane.showMessageDialog(null, "Conexão feita com sucesso");
        return true;
        } catch (ClassNotFoundException erro) {
        //JOptionPane.showMessageDialog(null, "Drive não encontrado");
            return false;
        } catch (SQLException erro) {
        //JOptionPane.showMessageDialog(null, "Banco de dados não encontrado");
            System.exit(0);
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
    
    public DefaultComboBoxModel<String> listarEstado(){
        
        ArrayList<String> estados = new ArrayList<>();
        
        if (conexaoBanco.getConexao()) {
            try {
            String sql = "SELECT * FROM TB_UFS;";
            statement = conexaoBanco.conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                estados.add(rs.getString("UF_UF"));
            }
            statement.execute();
            statement.close();

            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(estados.toArray());
        
        return model;
    }
    
     public DefaultComboBoxModel<String> listarCidades(int uf){
        
        ArrayList<String> cidades = new ArrayList<>();
        
        if (conexaoBanco.getConexao()) {
            try {            
            String sql = "SELECT CID_CIDADE FROM TB_CIDADES WHERE CID_UF_CODIGO = ?;";
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setInt(1, uf);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cidades.add(rs.getString("CID_CIDADE"));
            }
            statement.execute();
            statement.close();

            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(cidades.toArray());
        
        return model;
    }
    
    
}
