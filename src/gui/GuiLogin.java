package gui;

import dao.ConexaoDAO;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GuiLogin extends JFrame{
    
    private JLabel lbTitulo, lbLogin, lbSenha, lbImagem;
    private ImageIcon  imagem;
    private JTextField tfLogin;
    private JPasswordField pfSenha;
    private JButton btOk, btCancelar, btLimpar;
    
    public GuiLogin(){
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes(){
        
        setTitle("Sistema STBP");
        setBounds(0, 0, 315, 350);
        setLayout(null);
        
        lbTitulo = new JLabel("Insira seu nome e senha");
        lbLogin = new JLabel("Login");
        lbSenha = new JLabel("Senha");
        imagem = new ImageIcon("g:/SENAC/PROJETO FINAL/seminarioLogo.jpg");

        lbImagem = new JLabel(imagem);
        tfLogin = new JTextField();
        btOk = new JButton("Ok");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
        pfSenha = new JPasswordField();
        
        btOk.setMnemonic(KeyEvent.VK_ENTER);
        btCancelar.setMnemonic(KeyEvent.VK_C);
        btLimpar.setMnemonic(KeyEvent.VK_L);
        
        lbTitulo.setBounds(80, 20, 400, 25);
        lbLogin.setBounds(20, 60, 50, 25);
        lbSenha.setBounds(20, 100, 50, 25);
        lbImagem.setBounds(45, 170, 217, 147);
        
        
        tfLogin.setBounds(60, 60, 230, 25);
        pfSenha.setBounds(60, 100, 230, 25);
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
        add(pfSenha);
        add(lbImagem);   
    }
    
    public void definirEventos(){
         btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
         
         btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfLogin.setText(null);
                pfSenha.setText(null);
            }
        });
         
        btOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String nome = tfLogin.getText();
                String senha = String.valueOf(pfSenha.getPassword());
                ConexaoDAO conectarBanco = new ConexaoDAO();
                
                if(nome.equals("") && senha.equals("")){
                    conectarBanco.getConexao();
                    GuiMenu.mainMenu();
                    setVisible(false);
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Usuário inválido");
                
                }
            }
        });    
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GuiLogin guiLogin = new GuiLogin();
                
                guiLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiLogin.setResizable(false);
                
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                guiLogin.setLocation((tela.width-guiLogin.getSize().width)/2,
                        (tela.height-guiLogin.getSize().height)/2);
                
                guiLogin.setVisible(true);
            }
        });
    }   
}


