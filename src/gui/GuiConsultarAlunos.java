package gui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiConsultarAlunos extends JPanel{
    private JLabel lbTitulo, lbMatricula, lbNome, lbRua, lbNumero, lbBairro, lbTelResi, lbTelCel, lbUf, lbCidade;
    private JTextField tfMatricula;
    private JButton btLimpar, btCancelar, btConsultar;
    
    public GuiConsultarAlunos(){
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        lbTitulo = new JLabel("CONSULTAR ALUNO", JLabel.CENTER);
        lbMatricula = new JLabel("Matricula do aluno");
        lbNome = new JLabel("Nome:");
        lbRua = new JLabel("Rua:");
        lbBairro = new JLabel("Bairro:");
        lbCidade = new JLabel("Cidade:");
        lbUf = new JLabel("Estado:");
        lbTelResi = new JLabel("Tel. Residencial:");
        lbTelCel = new JLabel("Tel Celular:");
        lbNumero = new JLabel("Número:");
        tfMatricula = new JTextField();
        
        btConsultar = new JButton("Consultar");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
        
        lbTitulo.setBounds(45, 15, 400, 20);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbTitulo);
        
        lbMatricula.setBounds(25, 45, 200, 25);
        add(lbMatricula);
        tfMatricula.setBounds(140, 45, 150, 25);
        add(tfMatricula);
        
        lbNome.setBounds(25, 90, 100, 25);
        add(lbNome);
        lbRua.setBounds(25, 120, 100, 25);
        add(lbRua);
        lbNumero.setBounds(25, 150, 100, 25);
        add(lbNumero);
        lbBairro.setBounds(25, 180, 100, 25);
        add(lbBairro);
        lbCidade.setBounds(25, 210, 100, 25);
        add(lbCidade);
        lbUf.setBounds(25, 240, 100, 25);
        add(lbUf);
        lbTelResi.setBounds(25, 270, 100, 25);
        add(lbTelResi);
        lbTelCel.setBounds(25, 300, 100, 25);
        add(lbTelCel);
        
        btConsultar.setBounds(25,390, 100,25);
        add(btConsultar);
        btLimpar.setBounds(190, 390, 100, 25);
        add(btLimpar);      
        btCancelar.setBounds(370, 390, 100, 25);
        add(btCancelar);     
    }
    
    public void definirEventos(){
        
    }
}
