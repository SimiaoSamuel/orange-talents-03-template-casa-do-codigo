package com.orangetalents.casadocodigo.livro;

import com.orangetalents.casadocodigo.autor.AutorRepository;
import com.orangetalents.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;

    public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<LivroDto> saveLivro(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroForm.toLivro(categoriaRepository, autorRepository);
        Livro livroSalvo = livroRepository.save(livro);
        LivroDto livroDto = new LivroDto(livroSalvo);

        return ResponseEntity.ok(livroDto);
    }
}
