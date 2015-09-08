
package dao;

import Modelo.Funcionarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
    
    static PreparedStatement statement = null;
     
     public static void cadastrar(Funcionarios funcionario) {
         
        ConexaoDAO conexaoBanco = new ConexaoDAO();
        if (conexaoBanco.getConexao()) {
            try {
            String sql = "INSERT INTO TB_FUNCIONARIOS(FUN_LOGIN,FUN_SENHA) VALUES (?,?);";
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getLogin());
            statement.setString(2, funcionario.getSenha());
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
