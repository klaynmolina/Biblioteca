package br.com.klaynmolina.Biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.klaynmolina.Biblioteca.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}

