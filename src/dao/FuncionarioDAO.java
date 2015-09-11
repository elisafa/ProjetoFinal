
package dao;

import Modelo.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
    
    static PreparedStatement statement = null;
       
     public void cadastrarFuncionario(Funcionario funcionario) {
         
        ConexaoDAO conexaoBanco = new ConexaoDAO();
        if (conexaoBanco.getConexao()) {
            try {
            
            String sql2 = "INSERT INTO TB_FUNCIONARIOS(FUN_NOME, FUN_LOGRADOURO, FUN_NUMERO, FUN_DATA_ADMISSAO, FUN_LOGIN, FUN_SENHA,"
                                                      +"FUN_SEX_CODIGO, FUN_BAI_CODIGO) VALUES (?,?,?,?,?,?,?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql2);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getLogradouro());
            statement.setString(3, funcionario.getNumero());
            statement.setString(4, funcionario.getDataAdmissao());
            statement.setString(5, funcionario.getLogin());
            statement.setString(6, funcionario.getSenha());
            statement.setInt(7, funcionario.getSexo());
            statement.setInt(8, funcionario.getBairro());
            statement.execute();
            statement.close();            
            conexaoBanco.fecharConexao();
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
}
