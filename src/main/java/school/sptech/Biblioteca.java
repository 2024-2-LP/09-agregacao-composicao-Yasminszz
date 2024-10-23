package school.sptech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O livro não pode ser nulo.");
        }
        this.livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        }
        livros.removeIf(livro -> livro.toString().toLowerCase().contains(titulo.toLowerCase()));
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        }
        return livros.stream()
                .filter(livro -> livro.toString().toLowerCase().contains(titulo.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        return livros.stream()
                .filter(livro -> livro.toString().contains(ano.toString()))
                .collect(Collectors.toList());
    }

    public List<Livro> retornarTopCincoLivros() {
        return livros.stream()
                .sorted(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}

