package com.orangetalents.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Optional<Autor> findByEmailIgnoreCase(String email);
    Optional<Autor> findByNome(String nome);
}
