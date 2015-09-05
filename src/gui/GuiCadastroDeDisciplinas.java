
package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiCadastroDeDisciplinas extends JPanel{
    
    private JLabel lbNome, lbCargaHoraria, lbHoras, lbTitulo;
    private JTextField tfNome, tfCargaHoraria;
    private JButton btLimpar, btCancelar, btCadastrar;
    
    
    public GuiCadastroDeDisciplinas(){
        inicializarComponentes();
//        definirEventos();
    }
    
    public void inicializarComponentes(){
       
        setLayout(null);
        
        lbTitulo = new JLabel("CADASTRO DE DISCIPLINAS");
        lbNome = new JLabel("Nome da disciplina:");
        lbCargaHoraria = new JLabel("Carga Horária:");
        lbHoras = new JLabel("h(s)");
        tfNome = new JTextField();
        tfCargaHoraria = new JTextField();
        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
        
        lbTitulo.setBounds(110, 15, 400, 20);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbTitulo);
        
        lbNome.setBounds(25, 85,200, 25);
        add(lbNome);
        tfNome.setBounds(25, 105, 350, 25);
        add(tfNome);
        
        lbCargaHoraria.setBounds(25, 135, 300, 25);
        add(lbCargaHoraria);
        tfCargaHoraria.setBounds(25, 155, 50, 25);
        add(tfCargaHoraria);
        
        lbHoras.setBounds(75, 155, 155, 25);
        add(lbHoras);
        
       btCadastrar.setBounds(25,320, 100,25);
       add(btCadastrar);
       
       btLimpar.setBounds(190, 320, 100, 25);
       add(btLimpar);
       
       btCancelar.setBounds(370, 320, 100, 25);
       add(btCancelar);
    }
    
    public void definirEventos(){
        
        btLimpar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tfNome.setText(null);
                tfCargaHoraria.setText(null);
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
}
