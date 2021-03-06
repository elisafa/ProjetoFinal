package gui;

import dao.FuncionarioDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class GuiMenu extends JFrame{
    
    private JMenuBar mbBarra;
    private JMenu mnSecretaria, mnTurma, mnEventos, mnUtilitarios, mnRelatorios, mnFinancas,
                  mnCadastrar, mnConsultar, mnExcluir;
    private JMenuItem miCadAluno, miCadProf, miCadDisciplina,
                      miExAluno, miExProf, miExDisciplina,
                      miConsultAluno, miConsultProf, miConsultDisciplina,
                      miCriaTruma, miVisualizarTurma, miFinanAluno, miFinanProf,
                      miRelatAluno, miRelatProf, miEventCalendario, miInserirCalendario,
                      miUtilCalculadora, miSair, miCadFuncionario;
    private Container contentPane;
    
    public GuiMenu(){
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes(){
        setTitle("Sistema STBP");
        setBounds(0, 0, 500, 500);
        //setLayout(null);
        
        mbBarra = new JMenuBar();
        mnSecretaria = new JMenu("Secretaria");
        mnTurma = new JMenu("Turma");
        mnEventos = new JMenu("Eventos");
        mnUtilitarios = new JMenu("Utilitários");
        mnRelatorios = new JMenu("Relatórios");
        mnFinancas = new JMenu("Finanças");
        mnCadastrar = new JMenu("Cadastrar");
        mnConsultar = new JMenu("Consultar");
        mnExcluir = new JMenu("Excluir");
        
        miCadAluno = new JMenuItem("Cadastrar Aluno");
        miCadDisciplina = new JMenuItem("Cadastrar Disciplina");
        miCadProf = new JMenuItem("Cadastrar professor");
        miUtilCalculadora = new JMenuItem("Calculadora");
        miConsultAluno = new JMenuItem("Consultar aluno");
        miConsultDisciplina = new JMenuItem("Consultar disciplina");
        miConsultProf = new JMenuItem("Consultar professor");
        miCriaTruma = new JMenuItem("Criar turma");
        miVisualizarTurma = new JMenuItem("Visualizar Turma");
        miEventCalendario = new JMenuItem("Calendario");
        miExAluno = new JMenuItem("Excluir aluno");
        miExDisciplina = new JMenuItem("Excluir disciplina");
        miExProf = new JMenuItem("Excluir professor");
        miFinanAluno = new JMenuItem("Finanças do aluno");
        miFinanProf = new JMenuItem("Finanças do professor");
        miInserirCalendario = new JMenuItem("Inserir calendário");
        miRelatAluno = new JMenuItem("Relatório do aluno");
        miRelatProf = new JMenuItem("Relatório do professor");
        miSair = new JMenuItem("Sair");
        miCadFuncionario = new JMenuItem("Cadastrar funcionário");
        
        contentPane = getContentPane();
        
       miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        
        mnSecretaria.add(mnCadastrar);
        mnCadastrar.add(miCadAluno);
        mnCadastrar.add(miCadDisciplina);
        mnCadastrar.add(miCadProf);
        
        mnSecretaria.add(mnExcluir);
        mnExcluir.add(miExAluno);
        mnExcluir.add(miExProf);
        mnExcluir.add(miExDisciplina);
        
        mnSecretaria.add(mnConsultar);
        mnConsultar.add(miConsultAluno);
        mnConsultar.add(miConsultDisciplina);
        mnConsultar.add(miConsultProf);
        
        mnSecretaria.add(miSair);

        
        mnTurma.add(miCriaTruma);
        mnTurma.add(miVisualizarTurma);
        
        mnFinancas.add(miFinanAluno);
        mnFinancas.add(miFinanProf);
        
        mnUtilitarios.add(miUtilCalculadora);
        mnUtilitarios.add(miCadFuncionario);
                
        mnEventos.add(miEventCalendario);
        mnEventos.add(miInserirCalendario);
        
        mnRelatorios.add(miRelatAluno);
        mnRelatorios.add(miRelatProf);
        
        mbBarra.add(mnSecretaria);
        mbBarra.add(mnEventos);
        mbBarra.add(mnTurma);
        mbBarra.add(mnFinancas);
        mbBarra.add(mnUtilitarios);
        mbBarra.add(mnRelatorios);
        
        setJMenuBar(mbBarra);
    } 
    
    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0); //comando para sair do programa
            }
         });
        
        miCadAluno.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
               try{
                 GuiCadastroDeAlunos cadastroAluno = new GuiCadastroDeAlunos();
                 contentPane.removeAll();
                 contentPane.add(cadastroAluno);
                 contentPane.validate();
                 }catch(ParseException error){
                     JOptionPane.showMessageDialog(null, "Errou");
                }
            }
        });
        
//        miCadDisciplina.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                GuiCadastroDeDisciplinas cadastroDisciplina = new GuiCadastroDeDisciplinas();
//                 contentPane.removeAll();
//                 contentPane.add(cadastroDisciplina);
//                 contentPane.validate();
//            }
//        });
        
        miCadFuncionario.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                GuiCadastrarFuncionario cadastroFuncionario = new GuiCadastrarFuncionario();
                 contentPane.removeAll();
                 contentPane.add(cadastroFuncionario);
                 contentPane.validate();
            }catch(ParseException error){
                     JOptionPane.showMessageDialog(null, "Errou");
                }
            }
        });
        
//        miCadProf.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent ae) {
//            try{
//                GuiCadastroDeProfessores cadastroProfessor = new GuiCadastroDeProfessores();
//                 contentPane.removeAll();
//                 contentPane.add(cadastroProfessor);
//                 contentPane.validate();
//            }catch(ParseException error){
//                     JOptionPane.showMessageDialog(null, "Errou");
//                }
//             }
//        });
        
        miExProf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiExcluirProfessor excluirProfessor = new GuiExcluirProfessor();
                contentPane.removeAll();
                 contentPane.add(excluirProfessor);
                 contentPane.validate();
            }
        });
        
        miExAluno.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiExcluirAluno excluirAluno = new GuiExcluirAluno();
                contentPane.removeAll();
                 contentPane.add(excluirAluno);
                 contentPane.validate();
            }
        });
        
        miExDisciplina.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiExcluirDisciplina excluirDisciplina = new GuiExcluirDisciplina();
                contentPane.removeAll();
                contentPane.add(excluirDisciplina);
                contentPane.validate();
            }
        });
        
        miConsultAluno.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiConsultarAlunos consultarAluno = new GuiConsultarAlunos();
                contentPane.removeAll();
                contentPane.add(consultarAluno);
                contentPane.validate();
            }
        });
        
         miConsultProf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiConsultarProfessores consultarProfessor = new GuiConsultarProfessores();
                contentPane.removeAll();
                contentPane.add(consultarProfessor);
                contentPane.validate();
            }
        });
         
         miConsultDisciplina.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiConsultarDisciplinas consultarDisciplina = new GuiConsultarDisciplinas();
                contentPane.removeAll();
                contentPane.add(consultarDisciplina);
                contentPane.validate();
            }
        });
         
    }
      
    public static void mainMenu() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GuiMenu guiMenu = new GuiMenu();
                guiMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                guiMenu.setResizable(false);
                
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                
                guiMenu.setLocation((tela.width-guiMenu.getSize().width)/2,
                        (tela.height-guiMenu.getSize().height)/2);
                
                guiMenu.setVisible(true);
            }
        });
    }
}
