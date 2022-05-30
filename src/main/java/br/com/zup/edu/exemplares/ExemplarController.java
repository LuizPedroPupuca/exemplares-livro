package br.com.zup.edu.exemplares;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/{id}/exemplares")
public class ExemplarController {

    private final ExemplarRepository exemplarRepository;

    private final LivroRepository livroRepository;

    public ExemplarController(ExemplarRepository exemplarRepository, LivroRepository livroRepository) {
        this.exemplarRepository = exemplarRepository;
        this.livroRepository = livroRepository;
    }


    @PostMapping
    public ResponseEntity<Void> cadastra(@PathVariable Long id, UriComponentsBuilder uri){
        Livro livro = livroRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        Exemplar exemplar = new Exemplar(livro);
        exemplarRepository.save(exemplar);

        URI location = uri.path("/exemplares/{id}").buildAndExpand(exemplar.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
