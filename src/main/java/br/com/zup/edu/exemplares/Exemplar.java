package br.com.zup.edu.exemplares;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Exemplar {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    @ManyToOne(optional = false)
    private Livro livro;

    public Exemplar(Livro livro) {
        this.livro = livro;
    }

    @Deprecated
    public Exemplar() {
    }

    public Long getId() {
        return id;
    }
}
