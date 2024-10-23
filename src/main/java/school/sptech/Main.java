package school.sptech;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Java Programming", "John Doe", LocalDate.of(2020, 1, 15));
        Livro livro2 = new Livro("Python Programming", "Jane Doe", LocalDate.of(2018, 7, 22));

        livro1.adicionarAvaliacao("Ótimo livro!", 5.0);
        livro1.adicionarAvaliacao("Muito bom", 4.0);

        livro2.adicionarAvaliacao("Excelente!", 4.5);
        livro2.adicionarAvaliacao("Interessante", 3.5);

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        System.out.println("Total de livros: " + biblioteca.contarLivros());
        System.out.println("Top 5 livros: " + biblioteca.retornarTopCincoLivros());
    }
}
