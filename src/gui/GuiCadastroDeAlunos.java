
package gui;

import java.awt.Font;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class GuiCadastroDeAlunos extends JPanel {
    
    private JLabel lbNome, lbRua, lbComplemento, lbNumero,lbMatricula, lbSexo, lbUf, lbBairro,lbCidade, lbEmail, lbTelResi, lbTelCel, lbDataMatricula, lbTitulo;
    private JTextField tfNome, tfRua, tfComplemento, tfNumero, tfMatricula,tfBairro, tfCidade, tfEmail;
    private MaskFormatter ftTelResi,ftTelCel, ftDataMatricula;
    private JFormattedTextField ftfTelResi, ftfTelCel, ftfDataMatricula;
    private JButton btLimpar, btCancelar, btCadastrar;
    private JRadioButton rbMasculino, rbFeminino;
    private JComboBox cbUf;
    
    public GuiCadastroDeAlunos() throws ParseException{
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes() throws ParseException{
        setLayout(null);
        
        lbTitulo = new JLabel("CADASTRO DE ALUNOS", JLabel.CENTER);
        lbBairro = new JLabel("Bairro");
        lbCidade = new JLabel("Cidade");
        lbComplemento = new JLabel("Complemento");
        lbDataMatricula = new JLabel("Data da Matrícula");
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
        cbUf = new JComboBox();
        
        tfBairro = new JTextField();
        tfCidade = new JTextField();
        tfComplemento = new JTextField();
        tfMatricula = new JTextField();
        tfNome = new JTextField();
        tfNumero = new JTextField();
        tfRua = new JTextField();
        tfEmail = new JTextField();

        ftDataMatricula = new MaskFormatter("##/##/####");
        ftTelCel = new MaskFormatter("(##) #####-####");
        ftTelResi = new MaskFormatter("(##) #####-####");
        
        ftfDataMatricula = new JFormattedTextField(ftDataMatricula);
        ftfTelResi = new JFormattedTextField(ftTelResi);
        ftfTelCel = new JFormattedTextField(ftTelCel);
        
        lbTitulo.setBounds(45, 5, 400, 20);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbTitulo);
        
        lbNome.setBounds(25, 30, 100, 25);
        add(lbNome);
        tfNome.setBounds(25, 50, 350, 25);
        add(tfNome);
        
        lbSexo.setBounds(400, 30, 100, 25);
        add(lbSexo);
        rbMasculino.setBounds(380, 50, 40, 25);
        add(rbMasculino);
        rbFeminino.setBounds(430, 50,50, 25);
        add(rbFeminino);
        
        lbRua.setBounds(25, 80, 300, 25);
        add(lbRua);
        tfRua.setBounds(25, 100, 350, 25);
        add(tfRua);
        
        lbNumero.setBounds(380, 80, 100, 25);
        add(lbNumero);
        tfNumero.setBounds(380, 100, 94, 25);
        add(tfNumero);
        
        lbBairro.setBounds(170, 130, 100, 25);
        add(lbBairro);
        tfBairro.setBounds(170, 150, 150, 25);
        add(tfBairro);
        
        lbComplemento.setBounds(25, 130, 100, 25);
        add(lbComplemento);
        tfComplemento.setBounds(25, 150, 140, 25);
        add(tfComplemento);
        
        lbCidade.setBounds(325, 130, 100, 25);
        add(lbCidade);
        tfCidade.setBounds(325, 150, 150, 25);
        add(tfCidade);
        
        lbEmail.setBounds(170, 180, 100, 25);
        add(lbEmail);
        tfEmail.setBounds(170, 200, 310, 25);
        add(tfEmail);
        
        lbUf.setBounds(25, 180, 100, 25);
        add(lbUf);
        cbUf.setBounds(25, 200,140, 25);
        add(cbUf);
        
       lbTelResi.setBounds(25, 230, 100, 25);
       add(lbTelResi);
       ftfTelResi.setBounds(25, 250, 100, 25);
       add(ftfTelResi);
        
       lbTelCel.setBounds(140, 230, 100, 25);
       add(lbTelCel);
       ftfTelCel.setBounds(140, 250, 100, 25);
       add(ftfTelCel);
       
       lbDataMatricula.setBounds(255, 230, 100, 25);
       add(lbDataMatricula);
       ftfDataMatricula.setBounds(255, 250, 100, 25);
       add(ftfDataMatricula);
    }
    
    public void definirEventos(){
        
    }
    
}
