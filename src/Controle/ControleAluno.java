package Controle;

import Modelo.Aluno;
import dao.AlunoDAO;


public class ControleAluno {
    AlunoDAO alunoDAO = new AlunoDAO();
    
    public void cadastrarAluno(String nome, String logradouro, String numero, 
                               String complemento, String dataMatricula,
                               int bairro, int cidade, String email, 
                               String telResi, int sexo, int estado){
        
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setNumero(numero);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setDataMatricula(dataMatricula);
        aluno.setLogradouro(logradouro);
        aluno.setComplemento(complemento);
        aluno.setEmail(email);
        aluno.setTeleResidencial(telResi);
        aluno.setSexo(sexo);
        aluno.setUf(estado);
 
        alunoDAO.cadastrarAluno(aluno);
    }  
    
}
