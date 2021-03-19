package com.orangetalents.casadocodigo.estadopais;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    //Optional<Estado> findByPais(Pais pais);
    Optional<Estado> findByPaisId(Integer id);
    List<Estado> findByPais(Pais pais);
}
