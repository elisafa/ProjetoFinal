
package gui;

import Controle.ControleFuncionario;
import dao.ConexaoDAO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class GuiCadastrarFuncionario extends JPanel{
    ConexaoDAO conexao = new ConexaoDAO();
    ControleFuncionario controleFuncionario = new ControleFuncionario();

    private JLabel lbNome, lbRua, lbComplemento, lbNumero,lbMatricula, lbSexo, lbUf, lbBairro,lbCidade,
                   lbEmail, lbTelResi, lbDataAdmissao, lbTitulo, lbCadastrar, lbSenha, lbLogin;
    private JTextField tfNome, tfRua, tfComplemento, tfNumero, tfMatricula, tfEmail, tfLogin, tfSenha;
    private MaskFormatter ftTelResi,ftDataAdmissao;
    private JFormattedTextField ftfTelResi,ftfDataAdmissao;
    private JButton btLimpar, btCancelar, btCadastrar;
    private JRadioButton rbMasculino, rbFeminino;
    private JComboBox cbUf, cbCidades, cbBairros;
    
   
    
    public GuiCadastrarFuncionario() throws ParseException{
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes() throws ParseException{
           
        setLayout(null);
        
        lbTitulo = new JLabel("CADASTRO DE FUNCIONARIO", JLabel.CENTER);
        lbBairro = new JLabel("Bairro");
        lbCidade = new JLabel("Cidade");
        lbComplemento = new JLabel("Complemento");
        lbDataAdmissao = new JLabel("Dt. Admissao");
        lbEmail = new JLabel("E-mail");
        lbMatricula = new JLabel("Matrícula");
        lbNome = new JLabel("Nome");
        lbNumero = new JLabel("Número");
        lbRua = new JLabel("Rua, Logradouro, Av., etc");
        lbSexo = new JLabel("Sexo");
        lbTelResi = new JLabel("Tel. Residencial");
//        lbTelCel = new JLabel("Tel. Celular");
        lbUf = new JLabel("Estado");
        lbCadastrar = new JLabel("Cadastre sua senha e login:");
        lbSenha = new JLabel("Senha:");
        lbLogin = new JLabel("Login:");
        rbMasculino = new JRadioButton("M");
        rbFeminino = new JRadioButton("F");
        
        cbUf = new JComboBox(conexao.listarEstado());
        cbCidades = new JComboBox();
        cbBairros = new JComboBox();
        
        tfComplemento = new JTextField();
        tfMatricula = new JTextField();
        tfNome = new JTextField();
        tfNumero = new JTextField();
        tfRua = new JTextField();
        tfEmail = new JTextField();
//        tfDataAdmissao = new JTextField();
        tfSenha = new JTextField();
        tfLogin = new JTextField();

        ftDataAdmissao = new MaskFormatter("##/##/####");
//        ftTelCel = new MaskFormatter("(##) #####-####");
        ftTelResi = new MaskFormatter("(##) #####-####");
        
        ftfDataAdmissao = new JFormattedTextField(ftDataAdmissao);
        ftfTelResi = new JFormattedTextField(ftTelResi);
//        ftfTelCel = new JFormattedTextField(ftTelCel);
        
        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
                
        lbTitulo.setBounds(45, 15, 400, 20);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbTitulo);
        
        lbNome.setBounds(25, 45, 100, 25);
        add(lbNome);
        tfNome.setBounds(25, 65, 350, 25);
        add(tfNome);
        
        lbSexo.setBounds(400, 45, 100, 25);
        add(lbSexo);
        rbMasculino.setBounds(380, 65, 40, 25);
        add(rbMasculino);
        rbFeminino.setBounds(430, 65,50, 25);
        add(rbFeminino);
        
        lbRua.setBounds(25, 95, 300, 25);
        add(lbRua);
        tfRua.setBounds(25, 115, 350, 25);
        add(tfRua);
        
        lbNumero.setBounds(380, 95, 100, 25);
        add(lbNumero);
        tfNumero.setBounds(380, 115, 94, 25);
        add(tfNumero);
        
        lbBairro.setBounds(170, 145, 100, 25);
        add(lbBairro);
        cbBairros.setBounds(170, 165, 150, 25);
        add(cbBairros);
        
        lbComplemento.setBounds(25, 145, 100, 25);
        add(lbComplemento);
        tfComplemento.setBounds(25, 165, 140, 25);
        add(tfComplemento);
        
        lbCidade.setBounds(325, 145, 100, 25);
        add(lbCidade);
        cbCidades.setBounds(325, 165, 150, 25);
        add(cbCidades);
        
        lbEmail.setBounds(170, 195, 100, 25);
        add(lbEmail);
        tfEmail.setBounds(170, 215, 305, 25);
        add(tfEmail);
        
        lbUf.setBounds(25, 195, 100, 25);
        add(lbUf);
        cbUf.setBounds(25, 215,140, 25);
        add(cbUf);
        
       lbTelResi.setBounds(25, 245, 100, 25);
       add(lbTelResi);
       ftfTelResi.setBounds(25, 265, 100, 25);
       add(ftfTelResi);
        
//       lbTelCel.setBounds(140, 245, 100, 25);
//       add(lbTelCel);
//       ftfTelCel.setBounds(140, 265, 100, 25);
//       add(ftfTelCel);
       
       lbDataAdmissao.setBounds(255, 245, 100, 25);
       add(lbDataAdmissao);
       ftfDataAdmissao.setBounds(255, 265, 70, 25);
       add(ftfDataAdmissao);
       
       lbMatricula.setBounds(350, 245, 100, 25);
       add(lbMatricula);
       tfMatricula.setBounds(350, 265, 125, 25);
       add(tfMatricula);
       tfMatricula.setEnabled(false);
       
       btCadastrar.setBounds(25,400, 100,25);
       add(btCadastrar);
       
       btLimpar.setBounds(190, 400, 100, 25);
       add(btLimpar);
       
       btCancelar.setBounds(370, 400, 100, 25);
       add(btCancelar);
       
       lbCadastrar.setBounds(25, 300,200, 25);
       add(lbCadastrar);
       
       lbLogin.setBounds(25, 330, 100, 25);
       add(lbLogin);
       tfLogin.setBounds(65, 330, 100, 25);
       add(tfLogin);
       
       lbSenha.setBounds(190, 330, 100, 25);
       add(lbSenha);
       tfSenha.setBounds(230, 330, 100, 25);
       add(tfSenha);
    }
    
    public void definirEventos(){
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
         
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfNome.setText(null);
                tfRua.setText(null);
                tfComplemento.setText(null);
                tfNumero.setText(null);
                tfEmail.setText(null);
                ftfTelResi.setText(null);
//                ftfTelCel.setText(null);
                ftfDataAdmissao.setText(null);
                
            }
        });
         
         btCadastrar.addActionListener(new ActionListener() {

             public void actionPerformed(ActionEvent ae) {
                 int sexo;
                 String nome = tfNome.getText();
                 String rua = tfRua.getText();
                 String numero = tfNumero.getText();
                 String complemento = tfComplemento.getText();
                 String email = tfEmail.getText();
                 String telResi = ftfTelResi.getText();
//                 String telCel = ftfTelCel.getText();
                 String dataAdmissao = ftfDataAdmissao.getText();
                 String login = tfLogin.getText();
                 String senha = tfSenha.getText();
                 
                 if(rbFeminino.isSelected()){
                     sexo = 1;
                 }else{
                     sexo = 2; 
                 }
                 
               int estado = cbUf.getSelectedIndex()+1;
                int cidade = cbCidades.getSelectedIndex()+1;
                int bairro = cbBairros.getSelectedIndex()+1;
                 
            controleFuncionario.cadastrarFuncionario(nome, login, numero, complemento, bairro, cidade, email,
                                                     telResi, dataAdmissao, estado, sexo, login, senha);
             }
        });
  
         cbUf.addActionListener(new ActionListener() {

             public void actionPerformed(ActionEvent e) {
                 
                 String estado = cbUf.getSelectedItem().toString();
//                 
                 cbCidades.setVisible(false);
                 cbCidades = new JComboBox(conexao.listarCidades(estado));
//                 
                 cbCidades.setBounds(325, 165, 150, 25);
                 add(cbCidades);
             
                
                 cbCidades.addActionListener(new ActionListener() {

                     public void actionPerformed(ActionEvent e) {
                        String cidade = cbCidades.getSelectedItem().toString();
                        
                        cbBairros.setVisible(false);
                        cbBairros = new JComboBox(conexao.listarBairros(cidade));

                        cbBairros.setBounds(170, 165, 150, 25);
                        add(cbBairros);
                        
                     }
                 }); 
             }
         });                           
    }
}

