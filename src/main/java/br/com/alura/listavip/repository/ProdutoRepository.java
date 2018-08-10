package br.com.alura.listavip.repository;

import br.com.alura.listavip.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	List<Produto> findByNome(String nome);
}