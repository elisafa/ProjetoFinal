
package dao;

import Modelo.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
            
    static PreparedStatement statement = null;
    ConexaoDAO conexaoBanco = new ConexaoDAO();   
     
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (conexaoBanco.getConexao()) {
            try {
                      
            String sql = "INSERT INTO TB_FUNCIONARIOS(FUN_NOME, FUN_LOGRADOURO, FUN_NUMERO, FUN_COMPLEMENTO, FUN_DATA_ADMISSAO, FUN_LOGIN, FUN_SENHA,FUN_SEX_CODIGO, FUN_BAI_CODIGO) VALUES (?,?,?,?,?,?,?,?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getLogradouro());
            statement.setString(3, funcionario.getNumero());
            statement.setString(4, funcionario.getComplemento());
            statement.setString(5, funcionario.getDataAdmissao());
            statement.setString(6, funcionario.getLogin());
            statement.setString(7, funcionario.getSenha());
            statement.setInt(8, funcionario.getSexo());
            statement.setInt(9, funcionario.getBairro());            
            statement.execute();
            
//            statement.close();            
//            conexaoBanco.fecharConexao();
            cadastrarTelFuncionario(funcionario);
            cadastrarEmailFuncionario(funcionario);
                
            int codigo = 0;
            String sql3 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS;";
            statement = conexaoBanco.conexao.prepareStatement(sql3);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            codigo = rs.getInt("FUN_CODIGO");
            }
            
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso\n" + "Matricula de número: " + codigo);
                
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
            int codigo = 0;
            //String sql2 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS WHERE FUN_NOME = " + funcionario.getNome();
            String sql3 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS;";
         
            statement = conexaoBanco.conexao.prepareStatement(sql3);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            codigo = rs.getInt("FUN_CODIGO");
            }
            String sql = "INSERT INTO TB_FONE_FUNCIONARIOS (FDF_FONES, FDF_FUN_CODIGO) VALUES (?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getTeleResidencial());
            statement.setInt(2, codigo);
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
     
     public void cadastrarEmailFuncionario(Funcionario funcionario){
         if (conexaoBanco.getConexao()) {
            try {
            int codigo =0;

            String sql3 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS;";
         
            statement = conexaoBanco.conexao.prepareStatement(sql3);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            codigo = rs.getInt("FUN_CODIGO");
           }
            String sql = "INSERT INTO TB_EMAILS_FUNCIOANRIOS (EDF_EMAIL, EDF_FUN_CODIGO) VALUES (?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getEmail());
            statement.setInt(2, codigo);
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
