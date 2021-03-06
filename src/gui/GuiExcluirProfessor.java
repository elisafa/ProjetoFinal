package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiExcluirProfessor extends JPanel{
    
    private JLabel lbTitulo, lbMatricula;
    private JTextField tfMatricula;
    private JButton btLimpar, btCancelar, btExcluir;
    
    public GuiExcluirProfessor(){
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        lbTitulo = new JLabel("EXCLUIR PROFESSOR", JLabel.CENTER);
        lbMatricula = new JLabel("Matrícula do professor");
        tfMatricula = new JTextField();
        
        btExcluir = new JButton("Excluir");
        btCancelar = new JButton("Cancelar");
        btLimpar = new JButton("Limpar");
        
        lbTitulo.setBounds(45, 15, 400, 20);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbTitulo);
        
        lbMatricula.setBounds(180, 85, 200, 25);
        add(lbMatricula);
        
        tfMatricula.setBounds(170, 110, 150, 25);
        add(tfMatricula);
        
        btExcluir.setBounds(25,320, 100,25);
        add(btExcluir);
       
        btLimpar.setBounds(190, 320, 100, 25);
        add(btLimpar);
       
        btCancelar.setBounds(370, 320, 100, 25);
        add(btCancelar);     
    }
    
    public void definirEventos(){
        
        btCancelar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
    }
}
