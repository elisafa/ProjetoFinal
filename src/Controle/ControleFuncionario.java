
package Controle;

import Modelo.Funcionario;
import dao.FuncionarioDAO;

public class ControleFuncionario {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public void cadastrarUsuario(String nome, String senha){
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setSenha(senha);
        
        funcionarioDAO.cadastrarUsuario(funcionario);
    }
}