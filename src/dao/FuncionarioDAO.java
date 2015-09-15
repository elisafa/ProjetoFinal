
package dao;

import Modelo.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class FuncionarioDAO {
            
    static PreparedStatement statement = null;
    ConexaoDAO conexaoBanco = new ConexaoDAO();   
     
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (conexaoBanco.getConexao()) {
            try {
            
            String sql = "INSERT INTO TB_FUNCIONARIOS(FUN_NOME, FUN_LOGRADOURO, FUN_NUMERO, FUN_DATA_ADMISSAO, FUN_LOGIN, FUN_SENHA,FUN_SEX_CODIGO, FUN_BAI_CODIGO) VALUES (?,?,?,?,?,?,?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getLogradouro());
            statement.setString(3, funcionario.getNumero());
            statement.setString(4, funcionario.getDataAdmissao());
            statement.setString(5, funcionario.getLogin());
            statement.setString(6, funcionario.getSenha());
            statement.setInt(7, funcionario.getSexo());
            statement.setInt(8, funcionario.getBairro());            
            statement.execute();
            
//            statement.close();            
//            conexaoBanco.fecharConexao();
                cadastrarTelFuncionario(funcionario);
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
     
     public void cadastrarTelFuncionario(Funcionario funcionario){
         if (conexaoBanco.getConexao()) {
            try {
            
            String sql2 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS WHERE FUN_NOME = " + funcionario.getNome();
            statement = conexaoBanco.conexao.prepareStatement(sql2);
            ResultSet rs = statement.executeQuery();
            
            
            String sql = "INSERT INTO TB_FONES_FUNCIONARIOS (FDF_FONES, FDF_FUN_CODIGO) VALUES (?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getTeleResidencial());
            statement.execute();
            
//            statement.close();            
//            conexaoBanco.fecharConexao();
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }

}
