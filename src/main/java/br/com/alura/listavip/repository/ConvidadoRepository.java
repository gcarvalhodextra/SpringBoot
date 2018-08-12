package br.com.alura.listavip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.listavip.model.Convidado;

import javax.persistence.*;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

    List<Convidado> findByNome(String nome);

    List<Convidado> findByNomeOrTelefone(String nome, String telefone);

    List<Convidado> findByNomeOrTelefoneOrEmail(String nome, String telefone, String email);

    Convidado getByNomeLike(String nome);

    List<Convidado> findByNomeLike(String nome);

    List<Convidado> findByNacionalidade_Pais(String pais);
}