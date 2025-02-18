package model;

public abstract class Conteudo implements Materiais {
    private String titulo;
    private String autor;
    private int ano;
    public String modelo="defaut";

    public Conteudo(String titulo, String autor,int ano){
        this.titulo=titulo;
        this.autor=autor;
        this.ano=ano;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getAno(){
        return this.ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public abstract String getAtributos();
}
