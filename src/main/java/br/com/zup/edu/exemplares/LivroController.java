package br.com.zup.edu.exemplares;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid LivroRequest livroRequest, UriComponentsBuilder uri){
        Livro livro = livroRequest.toModel();
        livroRepository.save(livro);

        URI location = uri.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
