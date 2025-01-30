package model;

public class Revista extends Livro{
    private int volume;
    private int numero;
    public Revista(String titulo, String autor, int ano,int volume,int numero) {
        super(titulo, autor, ano); //chama o contrutor da super classe
        this.volume= volume;
        this.numero= numero;

    }

    public int getVolume(){
        return this.volume;
    }

    public void setVolume(int volume){
        this.volume= volume;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero= numero;
    }
}
