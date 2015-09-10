
package gui;

import Controle.ControleAluno;
import Controle.ControleFuncionario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class GuiCadastrarFuncionario extends JPanel{
    
    ControleFuncionario controleFuncionario = new ControleFuncionario();

    private JLabel lbNome, lbRua, lbComplemento, lbNumero,lbMatricula, lbSexo, lbUf, lbBairro,lbCidade, lbEmail, lbTelResi, lbTelCel, lbDataAdmissao, lbTitulo;
    private JTextField tfNome, tfRua, tfComplemento, tfNumero, tfMatricula,tfBairro, tfCidade, tfEmail, tfDataAdmissao;
    private MaskFormatter ftTelResi,ftTelCel;
    private JFormattedTextField ftfTelResi, ftfTelCel, ftfDataAdmissao;
    private JButton btLimpar, btCancelar, btCadastrar;
    private JRadioButton rbMasculino, rbFeminino;
    private JComboBox cbUf;
    String[] cbEstadosItens = {"Espírito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo", 
                               "Rio Grande do Norte"};
    
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
        lbTelCel = new JLabel("Tel. Celular");
        lbUf = new JLabel("Estado");
        rbMasculino = new JRadioButton("M");
        rbFeminino = new JRadioButton("F");
        cbUf = new JComboBox(cbEstadosItens);
        
        tfBairro = new JTextField();
        tfCidade = new JTextField();
        tfComplemento = new JTextField();
        tfMatricula = new JTextField();
        tfNome = new JTextField();
        tfNumero = new JTextField();
        tfRua = new JTextField();
        tfEmail = new JTextField();
        tfDataAdmissao = new JTextField();

//        ftDataAdmissao = new MaskFormatter("##/##/####");
        ftTelCel = new MaskFormatter("(##) #####-####");
        ftTelResi = new MaskFormatter("(##) #####-####");
        
//        ftfDataAdmissao = new JFormattedTextField(ftDataAdmissao);
        ftfTelResi = new JFormattedTextField(ftTelResi);
        ftfTelCel = new JFormattedTextField(ftTelCel);
        
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
        tfBairro.setBounds(170, 165, 150, 25);
        add(tfBairro);
        
        lbComplemento.setBounds(25, 145, 100, 25);
        add(lbComplemento);
        tfComplemento.setBounds(25, 165, 140, 25);
        add(tfComplemento);
        
        lbCidade.setBounds(325, 145, 100, 25);
        add(lbCidade);
        tfCidade.setBounds(325, 165, 150, 25);
        add(tfCidade);
        
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
        
       lbTelCel.setBounds(140, 245, 100, 25);
       add(lbTelCel);
       ftfTelCel.setBounds(140, 265, 100, 25);
       add(ftfTelCel);
       
       lbDataAdmissao.setBounds(255, 245, 100, 25);
       add(lbDataAdmissao);
       tfDataAdmissao.setBounds(255, 265, 70, 25);
       add(tfDataAdmissao);
       
       lbMatricula.setBounds(350, 245, 100, 25);
       add(lbMatricula);
       tfMatricula.setBounds(350, 265, 125, 25);
       add(tfMatricula);
       
       btCadastrar.setBounds(25,320, 100,25);
       add(btCadastrar);
       
       btLimpar.setBounds(190, 320, 100, 25);
       add(btLimpar);
       
       btCancelar.setBounds(370, 320, 100, 25);
       add(btCancelar);
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
                tfBairro.setText(null);
                tfCidade.setText(null);
                tfEmail.setText(null);
                ftfTelResi.setText(null);
                ftfTelCel.setText(null);
                tfDataAdmissao.setText(null);
                
            }
        });
         
         btCadastrar.addActionListener(new ActionListener() {

             public void actionPerformed(ActionEvent ae) {
                 String sexo ="";
                 String nome = tfNome.getText();
                 String rua = tfRua.getText();
                 String numero = tfNumero.getText();
                 String complemento = tfComplemento.getText();
                 String bairro = tfBairro.getText();
                 String cidade = tfCidade.getText();
                 String email = tfEmail.getText();
                 String telResi = ftfTelResi.getText();
                 String telCel = ftfTelCel.getText();
                 String dataAdmissao = tfDataAdmissao.getText();
                 
                 if(rbFeminino.isSelected()){
                     sexo = "1";
                 }else{
                     sexo = "2"; 
                 }
                 
                String estado = String.valueOf(cbUf.getSelectedIndex());
                 
            controleFuncionario.cadastrarFuncionario(nome, sexo, rua, numero, complemento,
                                                    bairro, cidade, estado, email,
                                                    telResi, telCel, dataAdmissao);
             }
        });
    }
}

