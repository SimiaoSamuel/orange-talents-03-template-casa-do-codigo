package com.orangetalents.casadocodigo.estadopais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<EstadoDto> saveEstado(@RequestBody @Valid EstadoForm estadoForm){
        Estado estado = estadoForm.toEstado(paisRepository);
        estadoRepository.save(estado);
        EstadoDto estadoDto = new EstadoDto(estado);
        return ResponseEntity.ok(estadoDto);
    }
}
