package projetoBiblioteca;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Usuario {
    private String nome;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome){
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void reservarItem(Item item) throws ItemIndisponivelException{
        item.reservar();
        Emprestimo emprestimo = new Emprestimo(item);
        emprestimos.add(emprestimo);
        System.out.println("Item " + item.getTitulo() + " reservado por " + nome +  " no dia: " + LocalDate.now() + " devolver até "
         + emprestimo.getDataEntrega());
    }

    public void devolverItem(Item item){
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.getItem() == item){
                item.devolver();
                emprestimos.remove(emprestimo);

                if(emprestimo.isAtrasado()){
                    double multa = emprestimo.calcularMulta();
                    System.out.println("Devolução atrasada, você deve pagar uma multa de R$ " + multa);
                }
                else{
                    System.out.println("Item devolvido por " + nome + " com sucesso! Volte sempre!!");
                }
                return;
            }
        }
        System.out.println("O item " + item.getTitulo() + " não está emprestado!");
    }
}
