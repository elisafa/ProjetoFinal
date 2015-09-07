package gui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiConsultarDisciplinas extends JPanel{
    private JLabel lbTitulo, lbMatricula, lbCargaHoraria, lbNome;
    private JTextField tfMatricula;
    private JButton btLimpar, btCancelar, btConsultar;
    
    public GuiConsultarDisciplinas(){
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        lbTitulo = new JLabel("CONSULTAR DISCIPLINA", JLabel.CENTER);
        lbMatricula = new JLabel("Matricula da disciplina:");
        lbCargaHoraria = new JLabel("Carga Horária:");
        lbNome = new JLabel("Nome da disciplina:");
        tfMatricula = new JTextField();
        
        btConsultar = new JButton("Consultar");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
        
        lbTitulo.setBounds(45, 15, 400, 20);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbTitulo);
        
        lbMatricula.setBounds(25, 45, 200, 25);
        add(lbMatricula);
        tfMatricula.setBounds(160, 45, 150, 25);
        add(tfMatricula);
        
        lbNome.setBounds(25, 90, 120, 25);
        add(lbNome);
        lbCargaHoraria.setBounds(25, 120, 100, 25);
        add(lbCargaHoraria);
        
        
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
