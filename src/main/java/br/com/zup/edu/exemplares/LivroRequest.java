package br.com.zup.edu.exemplares;

import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class LivroRequest {

    @NotBlank
    @ISBN(type = ISBN.Type.ANY)
    private String isbn;

    public LivroRequest(String isbn) {
        this.isbn = isbn;
    }

    public LivroRequest() {
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro toModel(){
        return new Livro(isbn);
    }
}
