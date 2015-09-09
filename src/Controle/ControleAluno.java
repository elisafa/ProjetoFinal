package Controle;

import Modelo.Aluno;
import Modelo.Funcionario;
import dao.AlunoDAO;
import dao.FuncionarioDAO;

public class ControleAluno {
    AlunoDAO alunoDAO = new AlunoDAO();
    
    public void cadastrarAluno(String nome, String logradouro, String numero, 
                               String complemento, String dataMatricula,
                               String bairro, String cidade, String email, 
                               String telResi, String telCel){
        
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
        aluno.setTelCelular(telCel);
 
        alunoDAO.cadastrarAluno(aluno);
    }
}
