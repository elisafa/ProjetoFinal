
package dao;

import Modelo.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlunoDAO {
    
    static PreparedStatement statement = null;
    
    ConexaoDAO conexaoBanco = new ConexaoDAO();   
     
    public void cadastrarAluno(Aluno aluno) {
        if (conexaoBanco.getConexao()) {
            try {
                
            int codIgreja = 0;
            String sql1 = "SELECT IGR_CODIGO FROM TB_IGREJAS;";
            statement = conexaoBanco.conexao.prepareStatement(sql1);
            ResultSet rsCodIgreja = statement.executeQuery();
            while(rsCodIgreja.next()){
            codIgreja = rsCodIgreja.getInt("IGR_CODIGO");
            }
            
            int codFun = 0;
            String sql2 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS;";
            statement = conexaoBanco.conexao.prepareStatement(sql2);
            ResultSet rsCodFun = statement.executeQuery();
            
            while(rsCodFun.next()){
            codFun = rsCodFun.getInt("FUN_CODIGO");
            }
            
            if(codFun==0){
                JOptionPane.showMessageDialog(null, "É necessário cadastrar um funcionario inicialmente");
            }
            else{
            String sq3 = "INSERT INTO TB_ALUNOS(ALU_NOME, ALU_LOGRADOURO, ALU_NUMERO, ALU_COMPLEMENTO, ALU_DATA_MATRICULA, "
                    + "ALU_SEX_CODIGO, ALU_BAI_CODIGO, ALU_FUN_CODIGO, ALU_IGR_CODIGO) VALUES (?,?,?,?,?,?,?,?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sq3);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getLogradouro());
            statement.setString(3, aluno.getNumero());
            statement.setString(4, aluno.getComplemento());
            statement.setString(5, aluno.getDataMatricula());
            statement.setInt(6, aluno.getSexo());
            statement.setInt(7, aluno.getBairro());
            statement.setInt(8, codFun);
            statement.setInt(9, codIgreja);            
            statement.execute();
            
            cadastrarTelAluno(aluno);
            cadastrarEmailAluno(aluno);
                
            int codAluno =0;
            String sql3 = "SELECT ALU_CODIGO FROM TB_ALUNOS;";
            statement = conexaoBanco.conexao.prepareStatement(sql3);
            
            ResultSet rs3 = statement.executeQuery();
            while(rs3.next()){
            codAluno = rs3.getInt("ALU_CODIGO");
           }
            
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso\n" + "Matricula de número: " + codAluno);
            }  
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
     
     public void cadastrarTelAluno(Aluno aluno){
         if (conexaoBanco.getConexao()) {
            try {
            int codigo = 0;
            //String sql2 = "SELECT FUN_CODIGO FROM TB_FUNCIONARIOS WHERE FUN_NOME = " + funcionario.getNome();
            String sql3 = "SELECT ALU_CODIGO FROM TB_ALUNOS;";
         
            statement = conexaoBanco.conexao.prepareStatement(sql3);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            codigo = rs.getInt("ALU_CODIGO");
            }
            String sql = "INSERT INTO TB_FONES_ALUNOS (FDA_FONES, FDA_ALU_CODIGO) VALUES (?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, aluno.getTeleResidencial());
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
     
     public void cadastrarEmailAluno(Aluno aluno){
         if (conexaoBanco.getConexao()) {
            try {
                
            int codigo =0;
            String sql3 = "SELECT ALU_CODIGO FROM TB_ALUNOS;";
            statement = conexaoBanco.conexao.prepareStatement(sql3); 
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            codigo = rs.getInt("ALU_CODIGO");
           }
            String sql = "INSERT INTO TB_EMAILS_ALUNOS (EDA_EMAIL, EDA_ALU_CODIGO) VALUES (?,?);";
            
            statement = conexaoBanco.conexao.prepareStatement(sql);
            statement.setString(1, aluno.getEmail());
            statement.setInt(2, codigo);
            statement.execute();
            
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
     
     public void consultarAluno(String matricula){
         if (conexaoBanco.getConexao()) {
            try {
            
            String  lograAluno = "";
            String nuAluno = "";
            String dataMatricula = "";
            String sexo ="";
            String igreja = "";
            String bairro = "";
            String cidade = "";
            String estado = "";
            String nomeAluno = "";
   
            String sql2 = "SELECT ALU_NOME, ALU_LOGRADOURO, ALU_NUMERO, ALU_COMPLEMENTO, ALU_DATA_MATRICULA, SEX_SEXO, IGR_NOME, BAI_BAIRRO, CID_CIDADE, UF_UF\n" +
                           "FROM TB_ALUNOS JOIN  TB_SEXOS ON SEX_CODIGO=ALU_SEX_CODIGO JOIN TB_IGREJAS ON IGR_CODIGO=ALU_IGR_CODIGO JOIN"
                         + " TB_BAIRROS ON BAI_CODIGO=ALU_BAI_CODIGO JOIN TB_CIDADES ON CID_CODIGO=ALU_BAI_CODIGO JOIN TB_UFS ON UF_CODIGO=ALU_BAI_CODIGO "
                         + "WHERE ALU_CODIGO LIKE ?;";
            
            statement = conexaoBanco.conexao.prepareStatement(sql2);
            statement.setString(1, matricula);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                nomeAluno = rs.getString("ALU_NOME");
                lograAluno = rs.getString("ALU_LOGRADOURO");
                nuAluno = rs.getString("ALU_NUMERO");
                sexo = rs.getString("SEX_SEXO");
                dataMatricula = rs.getString("ALU_DATA_MATRICULA");
                igreja = rs.getString("IGR_NOME");
                cidade = rs.getString("CID_CIDADE");
                bairro = rs.getString("BAI_BAIRRO");
                estado = rs.getString("UF_UF");                
            } 
            JOptionPane.showMessageDialog(null, "Nome do Aluno: " + nomeAluno +
                                                "\nLogradouro: "+ lograAluno +
                                                "\nNúmero: " + nuAluno +
                                                "\nSexo: " + String.valueOf(sexo) +
                                                "\nData da Matricula: " + dataMatricula +
                                                "\nNome da Igreja: " + igreja+
                                                "\nEstado: "+ estado+
                                                "\nCidade: " +cidade+
                                                "\nBairro: " + bairro);
            
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
     
      public void excluirAluno(String matricula){
         if (conexaoBanco.getConexao()) {
            try {
                excluirEmailAluno(matricula);
                excluirTelAluno(matricula);

                String sql = "DELETE FROM TB_ALUNOS WHERE ALU_CODIGO LIKE ?;";
                statement = conexaoBanco.conexao.prepareStatement(sql);
                statement.setString(1, "%"+matricula+"%");
                statement.execute();

                JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso" );
            
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
      
      public void excluirEmailAluno(String matricula){
         if (conexaoBanco.getConexao()) {
            try {
                String sql = "DELETE FROM TB_EMAILS_ALUNOS WHERE EDA_ALU_CODIGO LIKE ?;";
                statement = conexaoBanco.conexao.prepareStatement(sql);
                statement.setString(1, "%"+matricula+"%");
                statement.execute();
            
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }
      
      public void excluirTelAluno(String matricula){
         if (conexaoBanco.getConexao()) {
            try {
                String sql = "DELETE FROM TB_FONES_ALUNOS WHERE FDA_ALU_CODIGO LIKE ?;";
                statement = conexaoBanco.conexao.prepareStatement(sql);
                statement.setString(1, "%"+matricula+"%");
                statement.execute();
            
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
     }   
}
