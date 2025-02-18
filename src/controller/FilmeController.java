package controller;

import model.Conteudo;
import model.Filme;
import model.Revista;

import java.util.ArrayList;

public class FilmeController {
    public void AdicionaFilme(String titulo,String autor,int ano,String diretor ,ArrayList<Conteudo> Lista) {
        Filme filme = new Filme(titulo, autor, ano,diretor);
        Lista.add(filme);

    }
}
