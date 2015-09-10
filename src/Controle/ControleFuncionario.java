
package Controle;

import Modelo.Funcionario;
import dao.FuncionarioDAO;

public class ControleFuncionario {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public void cadastrarUsuario(String login, String senha){
        
        Funcionario funcionario = new Funcionario();
        funcionario.setLogin(login);
        funcionario.setSenha(senha);
        
        funcionarioDAO.cadastrarUsuario(funcionario);
    }
    
    public void cadastrarFuncionario(String nome, String logradouro, String numero, 
                               String complemento,String bairro, String cidade, String email, 
                               String telResi, String telCel, String dataAdmissao, String estado, String sexo){
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setNumero(numero);
        funcionario.setBairro(bairro);
        funcionario.setCidade(cidade);
        funcionario.setDataAdmissao(dataAdmissao);
        funcionario.setLogradouro(logradouro);
        funcionario.setComplemento(complemento);
        funcionario.setEmail(email);
        funcionario.setTeleResidencial(telResi);
        funcionario.setTelCelular(telCel);
        funcionario.setUf(estado);
 
       funcionarioDAO.cadastrarFuncionario(funcionario);
    }  
}