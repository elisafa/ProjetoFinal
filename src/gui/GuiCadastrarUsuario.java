package gui;

import Controle.ControleFuncionario;
import Modelo.Funcionario;
import dao.FuncionarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GuiCadastrarUsuario extends JPanel {
    
    ControleFuncionario controleFuncionario = new ControleFuncionario();
    
    private JLabel lbTitulo, lbLogin, lbSenha, lbImagem;
    private ImageIcon  imagem;
    private JTextField tfLogin, tfSenha;
    private JButton btOk, btCancelar, btLimpar;
    
    public GuiCadastrarUsuario(){
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes(){
        
        setBounds(0, 0, 315, 350);
        setLayout(null);
        
        lbTitulo = new JLabel("Insira seu nome e senha com 8 digitos cada");
        lbLogin = new JLabel("Login");
        lbSenha = new JLabel("Senha");
        imagem = new ImageIcon("e:/SENAC/PROJETO FINAL/seminarioLogo.jpg");

        lbImagem = new JLabel(imagem);
        tfLogin = new JTextField();
        btOk = new JButton("Ok");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
        tfSenha = new JTextField(8);
        
        btOk.setMnemonic(KeyEvent.VK_ENTER);
        btCancelar.setMnemonic(KeyEvent.VK_C);
        btLimpar.setMnemonic(KeyEvent.VK_L);
        
        lbTitulo.setBounds(80, 20, 400, 25);
        lbLogin.setBounds(20, 60, 50, 25);
        lbSenha.setBounds(20, 100, 50, 25);
        lbImagem.setBounds(45, 170, 217, 147);
        
        
        tfLogin.setBounds(60, 60, 230, 25);
        tfSenha.setBounds(60, 100, 230, 25);
        btLimpar.setBounds(20, 140, 80, 25);
        btCancelar.setBounds(115, 140, 100, 25);
        btOk.setBounds(230, 140, 60, 25);
        
        add(lbLogin);
        add(lbTitulo);
        add(lbSenha);
        add(btCancelar);
        add(btLimpar);
        add(btOk);
        add(tfLogin);
        add(tfSenha);
        add(lbImagem);   
    }
    
    public void definirEventos(){
     
        btOk.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                
               String login = tfLogin.getText();
               String senha = String.valueOf(tfSenha.getText());
               
               controleFuncionario.cadastrarUsuario(login, senha);
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                
            }
        });
        
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfLogin.setText(null);
                tfSenha.setText(null);
            }
        });
    }
}