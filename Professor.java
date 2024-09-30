package projetoBiblioteca;

public class Professor extends Usuario {
    public static final int max_reservas = 8;

    public Professor(String nome){
        super(nome);
    }

    @Override
    public void reservarItem(Item item) throws ItemIndisponivelException{
        if(getEmprestimos().size() >= max_reservas){
            throw new ItemIndisponivelException("O professor já atingiu o número máximo de reservas");
        }
        super.reservarItem(item);
    }
}
