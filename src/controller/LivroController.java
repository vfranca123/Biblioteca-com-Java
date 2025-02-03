package controller;

import java.util.ArrayList;
import  model.*;

public class LivroController {
    public void AdicionaLivro(String titulo,String autor,int ano, ArrayList<Livro> ListaLivro){
        Livro revista = new Livro(titulo,autor,ano);
        ListaLivro.add(revista);
    }


}
