package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Revista{
    public Revista(){ //construtor
        
        JFrame jframe = new JFrame();
        jframe.setSize(800,500);
        jframe.setTitle("Adiciona Revista");
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel tituloLabel= new JLabel("titulo");
        JTextField tituloField = new JTextField();

        JLabel organizacaoLabel = new JLabel("Organização");
        JTextField organizacaoField = new JTextField();

        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField();

        JLabel numeroLabel = new JLabel("Numero");
        JTextField numeroField = new JTextField();

        JButton Adicionar = new JButton("Adicionar");

        jframe.add(tituloLabel);
        jframe.add(tituloField);
        jframe.add(organizacaoLabel);
        jframe.add(organizacaoField);
        jframe.add(anoLabel);
        jframe.add(anoField);
        jframe.add(numeroLabel);
        jframe.add(numeroField);
        jframe.add(Adicionar);

        jframe.setVisible(true);
    }
}





