package view;

import model.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        ArrayList<Conteudo> listaMateriais = new ArrayList<>();

        JFrame janelaMain = new JFrame();
        JLabel Listagem = new JLabel("Listagem");
        janelaMain.setSize(800, 500);
        janelaMain.setTitle("Biblioteca");
        janelaMain.setLocationRelativeTo(null);
        janelaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaMain.setLayout(new BorderLayout());

                // Painel principal
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 2, 10, 10));

        JButton adicionarRevista = new JButton("Adicionar Revista");
        adicionarRevista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                janelaMain.setVisible(false);
                new RevistaView(listaMateriais, janelaMain);
            }
        });

        JButton adicionarFilme = new JButton("Adicionar Filme");
        adicionarRevista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                janelaMain.setVisible(false);
                new FilmeView(listaMateriais, janelaMain);
            }
        });

        JButton adicionarLivro = new JButton("Adicionar Livro");
        adicionarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                janelaMain.setVisible(false);
                new LivroView(listaMateriais, janelaMain);
            }
        });

        painelBotoes.add(adicionarRevista);
        painelBotoes.add(adicionarLivro);
        painelBotoes.add(adicionarFilme);

        //  Painel de Listagem
        JPanel painelListagem = new JPanel(new BorderLayout());

        JTextArea txtLista = new JTextArea();
        txtLista.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtLista);

        JButton btnAtualizar = new JButton("Atualizar Listagem");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtLista.setText(""); // Limpa antes de listar
                for (Conteudo material : listaMateriais) {
                        txtLista.append(material.getAtributos());

                }
            }
        });

        painelListagem.add(scrollPane, BorderLayout.CENTER);
        painelListagem.add(Listagem, BorderLayout.NORTH);

        painelBotoes.add(btnAtualizar);

        // Adiciona os painéis na janela principal
        janelaMain.add(painelBotoes, BorderLayout.SOUTH);
        janelaMain.add(painelListagem, BorderLayout.CENTER);

        janelaMain.setVisible(true);
    }
}
