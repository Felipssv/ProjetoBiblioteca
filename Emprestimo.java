package projetoBiblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Item item;
    private LocalDate dataReserva;
    private LocalDate dataEntrega;
    private static final int prazo_entrega = 7;
    private static final double multa_por_dia = 2.50;


public Emprestimo(Item item){
    this.item = item;
    this.dataReserva = LocalDate.now();
    this.dataEntrega = dataReserva.plusDays(prazo_entrega);
}

public Item getItem(){
    return item;
}

public LocalDate getDataReserva(){
    return dataReserva;
}

public LocalDate getDataEntrega(){
    return dataEntrega;
}

public long calcularDiasAtraso(){
    LocalDate hoje = LocalDate.now();
    if (hoje.isAfter(dataEntrega)){
        return ChronoUnit.DAYS.between(dataEntrega, hoje);
    }
    return 0;
}

public double calcularMulta(){
    long diasAtraso = calcularDiasAtraso();
    return diasAtraso * multa_por_dia;
}

public boolean isAtrasado(){
    return calcularDiasAtraso() > 0;
}
}
