package com.orangetalents.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorDto> saveAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) {
        Autor autor = autorForm.toAutor();
        autorRepository.save(autor);
        AutorDto autorDto = new AutorDto(autor);

        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autorDto.getId()).toUri();

        return ResponseEntity.created(uri).body(autorDto);
    }
}
