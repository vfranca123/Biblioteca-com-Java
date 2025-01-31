package controller;
import model.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RevistaController
{
    public void adicionaRevista(String titulo, String organizacao, int ano, int volume, int numero, ArrayList<Revista> lista) {
        Revista revista = new Revista(titulo, organizacao, ano, volume, numero);
        lista.add(revista);
        System.out.println("Revista adicionada: " + revista.getAtributos());


    }
}
