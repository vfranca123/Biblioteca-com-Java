package model;

public class Livro extends Conteudo{

    public Livro(String titulo,String autor,int ano){
        super(titulo, autor, ano);
    }

    public String getModelo(){
        return this.modelo;
    }

    public String getAtributos(){
        return "Livro  " +
                "titulo='" + this.getTitulo() + '\'' +
                ", autor='" + this.getAutor() + '\'' +
                ", ano="+ this.getAno() +
                '\n';
    }

}
