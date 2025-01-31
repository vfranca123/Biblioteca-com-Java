package view;

import model.*;
import java.util.ArrayList;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Revista> listaRevistas = new ArrayList<>();
        ArrayList<Livro> ListaLivro = new ArrayList<>();

        JFrame JanelaMain = new JFrame();
        JanelaMain.setSize(800,500);
        JanelaMain.setTitle("Biblioteca");
        JanelaMain.setLocationRelativeTo(null);
        JanelaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JanelaMain.setLayout(new GridLayout(8, 3, 5, 30));

        JButton AdicionarRevista = new JButton("Adicionar Revista");
        AdicionarRevista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JanelaMain.setVisible(false);
                new RevistaView(listaRevistas,JanelaMain);
            }
        });

        JanelaMain.add(AdicionarRevista);

        JanelaMain.setVisible(true);


    }

}