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

    //Gets e sets 
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
    @Override
    public String getTitulo(){
        return titulo;
    }

    @Override
    public void reservar() throws ItemIndisponivelException{
        if (disponivel = false){
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
