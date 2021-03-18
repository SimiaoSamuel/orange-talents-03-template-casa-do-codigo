package com.orangetalents.casadocodigo.estadopais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public PaisController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<PaisDto> savePais(@RequestBody @Valid PaisForm paisForm) {
        Pais pais = paisForm.toPais();
        paisRepository.save(pais);
        PaisDto paisDto = new PaisDto(pais);

        return ResponseEntity.ok(paisDto);
    }
}
