package com.orangetalents.casadocodigo.livro;

import com.orangetalents.casadocodigo.autor.AutorRepository;
import com.orangetalents.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        System.out.println(livroForm);
        Livro livro = livroForm.toLivro(categoriaRepository, autorRepository);
        Livro livroSalvo = livroRepository.save(livro);
        LivroDto livroDto = new LivroDto(livroSalvo);

        return ResponseEntity.ok(livroDto);
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> listLivros(){
        List<Livro> livros = livroRepository.findAll();
        List<LivroDto> livrosDto = LivroDto.toListOfLivroDto(livros);
        return ResponseEntity.ok(livrosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> getLivroById(@PathVariable Integer id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()) {
            LivroDto livroDto = new LivroDto(livro.get());
            return ResponseEntity.ok(livroDto);
        }
        return ResponseEntity.notFound().build();
    }
}
