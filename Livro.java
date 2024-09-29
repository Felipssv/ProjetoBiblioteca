package projetoBiblioteca;

public class Livro implements Item{
    private String titulo;
    private String autor;
    private String editora;
    private boolean disponivel;

//Construtor da classe
    public Livro(String titulo, String autor, String editora){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.disponivel = true;
    }

    public String getAutor(){
        return autor;
    }
    
    @Override
    public String getEditora() {
        return editora;
    }

    @Override
    public String getTitulo(){
        return titulo;
    }
    
    @Override
    public void reservar() throws ItemIndisponivelException{
        if (!disponivel){
            throw new ItemIndisponivelException("O livro %s não está disponível!");
        }
        disponivel = false;
    }
    
    @Override
    public void devolver(){
        disponivel = true;
    }

    @Override
    public boolean isDisponivel(){
        return disponivel;
    }
}
