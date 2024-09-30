package projetoBiblioteca;
import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private List<Item> acervo;
    private List<Usuario> usuarios;
    
    public Biblioteca(){
        this.acervo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarItem(Item item){
        acervo.add(item);
    }

    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void reservarItem(Usuario usuario, String titulo){
        for (Item item : acervo){
            if (item.getTitulo() == (titulo)){
                try{
                    usuario.reservarItem(item);  
                    return;
                } catch(ItemIndisponivelException e){
                    System.out.println("O item não está disponível! " + e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Item não encontrado!");
    }
    public void devolverItem(Usuario usuario, String titulo){
        for(Emprestimo emprestimo : usuario.getEmprestimos()){
            if (emprestimo.getItem().getTitulo() == (titulo)){
                usuario.devolverItem(emprestimo.getItem());
                return;
            }
        }
        System.out.printf("O item %s não está reservado", titulo);
    }
}
