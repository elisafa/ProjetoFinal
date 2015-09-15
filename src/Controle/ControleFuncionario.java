
package Controle;

import Modelo.Funcionario;
import dao.FuncionarioDAO;

public class ControleFuncionario {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public void cadastrarFuncionario(String nome, String logradouro, String numero, 
                               String complemento,int bairro, int cidade, String email, 
                               String telResi, String telCel, String dataAdmissao, int estado, int sexo, String login, String senha){
        
        Funcionario funcionario = new Funcionario();
        
        funcionario.setNome(nome);
        funcionario.setLogradouro(logradouro);
        funcionario.setNumero(numero);
        funcionario.setDataAdmissao(dataAdmissao);
        funcionario.setLogin(login);
        funcionario.setSenha(senha);       
        funcionario.setSexo(sexo);
        funcionario.setBairro(bairro);
        
        funcionario.setCidade(cidade);       
        funcionario.setComplemento(complemento);
        funcionario.setEmail(email);
        funcionario.setTeleResidencial(telResi);
        funcionario.setTelCelular(telCel);
        funcionario.setUf(estado);
        
 
       funcionarioDAO.cadastrarFuncionario(funcionario);
    } 
    
}