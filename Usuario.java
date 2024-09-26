package projetoBiblioteca;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Usuario {
    private String nome;
    private List<Item> itensReservados;

    public Usuario(String nome){
        this.nome = nome;
        this.itensReservados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getItensReservados() {
        return itensReservados;
    }

    public void reservarItem(Item item) throws ItemIndisponivelException{
        item.reservar();
        itensReservados.add(item);
        System.out.println("Item" + item.getTitulo() + " reservado por " + nome +  " no dia: " + LocalDate.now());
    }

    public void devolverItem(Item item){
        item.devolver();
        itensReservados.remove(item);
        System.out.println("Item" + item.getTitulo() + " devolvido por " + nome +  " no dia: " + LocalDate.now());
    }
}

