package projetoBiblioteca;

public interface Item {
    String getTitulo();
    void reservar() throws ItemIndisponivelException;
    void devolver();
    boolean isDisponivel();
    
}
