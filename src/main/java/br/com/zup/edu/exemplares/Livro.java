package br.com.zup.edu.exemplares;

import javax.persistence.*;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String isbn;

    public Livro(String isbn) {
        this.isbn = isbn;
    }

    @Deprecated
    public Livro() {
    }

    public Long getId() {
        return id;
    }
}
