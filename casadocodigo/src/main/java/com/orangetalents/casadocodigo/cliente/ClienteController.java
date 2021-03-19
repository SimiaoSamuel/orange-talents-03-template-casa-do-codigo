package com.orangetalents.casadocodigo.cliente;

import com.orangetalents.casadocodigo.estadopais.EstadoRepository;
import com.orangetalents.casadocodigo.estadopais.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<ClienteDto> saveCliente(@RequestBody @Valid ClienteForm clienteForm){
        Cliente cliente = clienteForm.toCliente(estadoRepository, paisRepository);
        clienteRepository.save(cliente);
        ClienteDto clienteDto = new ClienteDto(cliente);

        return ResponseEntity.ok(clienteDto);
    }
}
