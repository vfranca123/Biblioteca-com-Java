package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.LivroController;
import model.*;
public class LivroView {
    public LivroView(ArrayList<Conteudo> listaLivro, JFrame janelaMain) {
        // Criando a janela principal
        JFrame jframe = new JFrame("Adicionar Livro");
        jframe.setSize(500, 400);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setLayout(new BorderLayout(10, 10));

        // Painel para os campos de entrada
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tituloLabel = new JLabel("Título:");
        JTextField tituloField = new JTextField();

        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField();

        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField();

        // Adicionando componentes ao painel
        painelCampos.add(tituloLabel);
        painelCampos.add(tituloField);
        painelCampos.add(autorLabel);
        painelCampos.add(autorField);
        painelCampos.add(anoLabel);
        painelCampos.add(anoField);

        // Criando os botões
        JButton adicionarBtn = new JButton("Incluir");
        JButton bibliotecaBtn = new JButton("Biblioteca");
        JButton abrirRevistaBtn = new JButton("Revista");

        // Ajustando a fonte dos botões
        Font botaoFonte = new Font("Arial", Font.BOLD, 14);
        adicionarBtn.setFont(botaoFonte);
        bibliotecaBtn.setFont(botaoFonte);
        abrirRevistaBtn.setFont(botaoFonte);

        // Definição do controlador
        LivroController controller = new LivroController();

        // Ação do botão Adicionar
        adicionarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = tituloField.getText();
                    String autor = autorField.getText();
                    int ano = Integer.parseInt(anoField.getText());

                    // Limpar os campos após adicionar
                    tituloField.setText("");
                    autorField.setText("");
                    anoField.setText("");

                    controller.AdicionaLivro(titulo, autor, ano, listaLivro);

                    JOptionPane.showMessageDialog(jframe, "Livro adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jframe, "Erro: Ano deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão Biblioteca
        bibliotecaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jframe.dispose();
                janelaMain.setVisible(true);
            }
        });

        // Ação do botão Abrir Revista
        abrirRevistaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jframe.dispose();
                new RevistaView(listaLivro, janelaMain);
            }
        });

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.add(abrirRevistaBtn);
        painelBotoes.add(bibliotecaBtn);
        painelBotoes.add(adicionarBtn);

        // Adicionando os componentes à janela
        jframe.add(painelCampos, BorderLayout.CENTER);
        jframe.add(painelBotoes, BorderLayout.SOUTH);

        jframe.setVisible(true);
    }
}
