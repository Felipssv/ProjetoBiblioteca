package projetoBiblioteca;

public class Revista implements Item{
    
    private String titulo;
    private boolean disponivel;
    private String editora;

    public Revista(String titulo, String editora){
        this.titulo = titulo;
        this.editora = editora;
        this.disponivel = true;
    }

    @Override
    public String getTitulo(){
        return titulo;
    }

    @Override
    public String getEditora(){
        return editora;
    }

    @Override
    public void reservar() throws ItemIndisponivelException{
        if (!disponivel){
            throw new ItemIndisponivelException("A revista " + titulo + " não está disponível!");
        }
        disponivel = false;
    }

    @Override
    public void devolver(){
        disponivel = true;
    }

    public boolean isDisponivel(){
        return disponivel;
    }
}
