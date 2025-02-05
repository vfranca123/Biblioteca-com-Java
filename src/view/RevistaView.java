package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.RevistaController;
import model.Livro;
import model.Revista;


public class RevistaView{
    public RevistaView(ArrayList<Livro> listaObjetos, JFrame JanelaMain){ //construtor

        // Criando a janela principal
        JFrame jframe = new JFrame("Adicionar Revista");
        jframe.setSize(500, 400);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setLayout(new BorderLayout(10, 10));

        // Painel para os campos de entrada
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 10, 10));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tituloLabel = new JLabel("Título:");
        JTextField tituloField = new JTextField();

        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField();

        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField();

        JLabel numeroLabel = new JLabel("Número:");
        JTextField numeroField = new JTextField();

        JLabel volumeLabel = new JLabel("Volume:");
        JTextField volumeField = new JTextField();

        // Adicionando os componentes ao painel
        painelCampos.add(tituloLabel);
        painelCampos.add(tituloField);
        painelCampos.add(autorLabel);
        painelCampos.add(autorField);
        painelCampos.add(anoLabel);
        painelCampos.add(anoField);
        painelCampos.add(numeroLabel);
        painelCampos.add(numeroField);
        painelCampos.add(volumeLabel);
        painelCampos.add(volumeField);

        // Criando os botões
        JButton adicionarBtn = new JButton("Incluir");
        JButton bibliotecaBtn = new JButton("Biblioteca");
        JButton abrirLivroBtn = new JButton("Livro");

        // Ajustando a fonte dos botões
        Font botaoFonte = new Font("Arial", Font.BOLD, 14);
        adicionarBtn.setFont(botaoFonte);
        bibliotecaBtn.setFont(botaoFonte);
        abrirLivroBtn.setFont(botaoFonte);

        // Definição do controlador
        RevistaController controller = new RevistaController();

        // Ação do botão Adicionar
        adicionarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = tituloField.getText();
                    String organizacao = autorField.getText();
                    int ano = Integer.parseInt(anoField.getText());
                    int numero = Integer.parseInt(numeroField.getText());
                    int volume = Integer.parseInt(volumeField.getText());

                    // Limpar os campos após adicionar
                    tituloField.setText("");
                    autorField.setText("");
                    anoField.setText("");
                    numeroField.setText("");
                    volumeField.setText("");

                    controller.adicionaRevista(titulo, organizacao, ano, volume, numero, listaObjetos);

                    JOptionPane.showMessageDialog(jframe, "Revista adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jframe, "Erro: Ano, Número e Volume precisam ser números.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão Biblioteca
        bibliotecaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jframe.dispose();
                JanelaMain.setVisible(true);
            }
        });

        // Ação do botão Abrir Livro
        abrirLivroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jframe.dispose();
                new LivroView(listaObjetos, JanelaMain);
            }
        });

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.add(abrirLivroBtn);
        painelBotoes.add(bibliotecaBtn);
        painelBotoes.add(adicionarBtn);

        // Adicionando os componentes à janela
        jframe.add(painelCampos, BorderLayout.CENTER);
        jframe.add(painelBotoes, BorderLayout.SOUTH);

        jframe.setVisible(true);
    }
}





