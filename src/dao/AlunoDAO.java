
package dao;

import Modelo.Aluno;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {
    static PreparedStatement statement = null;
    
    static ConexaoDAO conexaoBanco = new ConexaoDAO();
             
     public void cadastrarAluno(Aluno aluno) {
         
        if (conexaoBanco.getConexao()) {
            try {
            String sql = "INSERT INTO TB_ALUNOS(ALU_NOME, ALU_BAIRRO) VALUES (?,?);";
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setInt(2, aluno.getBairro());
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
