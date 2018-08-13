package br.com.alura.listavip.dto;

import br.com.alura.listavip.model.Produto;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {

  private Long id;
  private String nome;

  public ProdutoDTO(Produto produto) {
    this.id = produto.getId();
    this.nome = produto.getNome();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}