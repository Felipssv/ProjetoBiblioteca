package projetoBiblioteca;


public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R Tolken", "Happer Collins Brasil");
        Livro livro2 = new Livro("1984", "George Orwell", "Companhia das letras");
        Revista revista1 = new Revista("Veja 2", "Veja");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(revista1);

        // Criando usuários
        Aluno aluno1 = new Aluno("Jorge");
        Professor professor1 = new Professor("Dr. Leôncio");

        biblioteca.adicionarUsuario(aluno1);
        biblioteca.adicionarUsuario(professor1);

        // Reservando itens
        biblioteca.reservarItem(aluno1, "1984");
        biblioteca.reservarItem(professor1, "O Senhor dos Anéis");

        // Tentativa de emprestar item indisponível
        biblioteca.reservarItem(aluno1, "O Senhor dos Anéis");

        // Simulação de devolução sem multa
        biblioteca.devolverItem(professor1, "O Senhor dos Anéis");

        // Simulação de devolução com multa (alterar data)
        biblioteca.devolverItem(aluno1, "1984");

        // Devolvendo item
        biblioteca.devolverItem(professor1, "O Senhor dos Anéis");

        // Tentativa de devolver um item não emprestado
        biblioteca.devolverItem(aluno1, "O Senhor dos Anéis");
    }
}
