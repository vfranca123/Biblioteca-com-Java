package view;

import model.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaMateriais = new ArrayList<>();

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
                for (Livro material : listaMateriais) {
                    if (material instanceof Revista) {
                        Revista revista = (Revista) material; // Faz o cast para Revista
                        txtLista.append(
                                revista.getModelo()+ "  "+
                                "Título: " + revista.getTitulo() +
                                " - Autor: " + revista.getAutor() +
                                " - Ano: " + revista.getAno() +
                                " - Volume: " + revista.getVolume() +
                                "- Numero" +revista.getNumero()+"\n"
                                );
                    } else {
                        txtLista.append(
                                material.getModelo()+ "  "+
                                "Título: " + material.getTitulo() +
                                " - Autor: " + material.getAutor() +
                                " - Ano: " + material.getAno() + "\n"
                                );
                    }
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
