package br.com.alura.listavip.repository;

import br.com.alura.listavip.model.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
}