
package dao;

import Modelo.Aluno;
import Modelo.Funcionario;
import gui.GuiCadastroDeAlunos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class AlunoDAO {
    static PreparedStatement statement = null;
    
    static ConexaoDAO conexaoBanco = new ConexaoDAO();
             
     public void cadastrarAluno(Aluno aluno) {
         
        if (conexaoBanco.getConexao()) {
            try {
            String sql = "INSERT INTO TB_ALUNOS(ALU_NOME, ALU_BAIRRO) VALUES (?,?);";
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getBairro());
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
     
     public void listarEstado(){
         
        ArrayList<String> estados = new ArrayList<>();
         
        if (conexaoBanco.getConexao()) {
            try {
            String sql = "SELECT * FROM TB_UFS;";
            statement = conexaoBanco.conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                estados.add(rs.getString("UF_SIGLA"));
            }
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
