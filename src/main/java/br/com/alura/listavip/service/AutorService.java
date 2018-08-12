package br.com.alura.listavip.service;

import br.com.alura.listavip.model.Autor;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.AutorRepository;
import br.com.alura.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository repository;

    public Iterable<Autor> findAll() {
        return repository.findAll();
    }

    public void save(Autor autor) {
        repository.save(autor);
    }
}