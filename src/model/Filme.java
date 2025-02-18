package model;

public class Filme extends Conteudo{
    String diretor;
    public  Filme(String titulo,String autor,int ano,String diretor){
        super(titulo, autor, ano);
        this.diretor=diretor;
    }

    public String getDiretor(){
        return this.diretor;
    }
    @Override
    public String getAtributos() {
        return "Livro  " +
                "titulo='" + this.getTitulo() + '\'' +
                ", autor='" + this.getAutor() + '\'' +
                ", ano="+ this.getAno() +
                ", diretor=" +this.getDiretor()+
                '\n';
    }
}
