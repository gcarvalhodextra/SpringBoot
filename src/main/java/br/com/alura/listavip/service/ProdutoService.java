package br.com.alura.listavip.service;

import br.com.alura.listavip.model.Produto;
import br.com.alura.listavip.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  ProdutoRepository produtoRepository;

  public Iterable<Produto> findAll() {
    return produtoRepository.findAll();
  }

  public Produto save(Produto produto) {
    return produtoRepository.save(produto);
  }

  public Produto findOne(Long id) {
    return produtoRepository.findOne(id);
  }

  public void delete(Long id) {
    produtoRepository.delete(id);
  }
}