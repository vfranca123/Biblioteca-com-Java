package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.RevistaController;
import model.Revista;


public class RevistaView{
    public RevistaView(ArrayList<Revista> listaObjetos,JFrame JanelaMain){ //construtor
        
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

        JLabel numeroLabel = new JLabel("Numero");
        JTextField numeroField = new JTextField();

        JLabel volumeLabel = new JLabel("Volume");
        JTextField volumeField = new JTextField();

        RevistaController controller = new RevistaController();

        JButton Adicionar = new JButton("Adicionar");
        Adicionar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try{
                    String titulo = tituloField.getText();
                    String organizacao = autorField.getText();
                    int ano = Integer.parseInt(anoField.getText());
                    int numero = Integer.parseInt(numeroField.getText());
                    int volume = Integer.parseInt(volumeField.getText());

                    controller.adicionaRevista(titulo, organizacao, ano, volume, numero, listaObjetos);

                }catch (NumberFormatException ex) {
                    System.out.println("Erro: Ano, Número e Volume precisam ser números.");
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
        jframe.add(numeroLabel);
        jframe.add(numeroField);
        jframe.add(volumeLabel);
        jframe.add(volumeField);
        jframe.add(Adicionar);
        jframe.add(Biblioteca);

        jframe.setVisible(true);
    }
}





