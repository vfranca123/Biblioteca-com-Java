package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.LivroController;
import model.*;
public class LivroView {
    public LivroView(ArrayList<Livro> ListaLivro,JFrame JanelaMain){
        JFrame jframe = new JFrame();
        jframe.setSize(800,500);
        jframe.setTitle("Adiciona Revista");
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(8, 3, 5, 30));

        JLabel tituloLabel= new JLabel("titulo");
        JTextField tituloField = new JTextField();

        JLabel autorLabel = new JLabel("Autor");
        JTextField autorField = new JTextField();

        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField();

        LivroController controller = new LivroController();

        JButton Adicionar = new JButton("Adicionar");
        Adicionar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try{
                    String titulo = tituloField.getText();
                    String autor = autorField.getText();
                    int ano = Integer.parseInt(anoField.getText());

                    controller.AdicionaLivro(titulo, autor, ano, ListaLivro);

                }catch (NumberFormatException ex) {
                    System.out.println("Erro: Ano precisam ser números.");
                }
            }
        });

        JButton Biblioteca = new JButton("Biblioteca");
        Biblioteca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jframe.setVisible(false);
                JanelaMain.setVisible(true);
            }
        });


        jframe.add(tituloLabel);
        jframe.add(tituloField);
        jframe.add(autorLabel);
        jframe.add(autorField);
        jframe.add(anoLabel);
        jframe.add(anoField);
        jframe.add(Adicionar);
        jframe.add(Biblioteca);

        jframe.setVisible(true);
    }
}
