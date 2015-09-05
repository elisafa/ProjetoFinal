
package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        lbDataMatricula = new JLabel("Dt. Matrícula");
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
        tfEmail.setBounds(170, 215, 310, 25);
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
       
       lbDataMatricula.setBounds(255, 245, 100, 25);
       add(lbDataMatricula);
       ftfDataMatricula.setBounds(255, 265, 70, 25);
       add(ftfDataMatricula);
       
       lbMatricula.setBounds(350, 245, 100, 25);
       add(lbMatricula);
       tfMatricula.setBounds(350, 265, 70, 25);
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
                System.exit(0);
            }
        });
         btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                tfLogin.setText(null);
//                pfSenha.setText(null);
            }
        });
    }
    
}
