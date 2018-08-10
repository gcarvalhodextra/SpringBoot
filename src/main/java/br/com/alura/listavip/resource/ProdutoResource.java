package br.com.alura.listavip.resource;

import br.com.alura.listavip.model.Produto;
import br.com.alura.listavip.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoResource {

  /*
  @RequestParam("nome") String nome - Body
  @PathVariable Long id - URL
  */

  @Autowired
  private ProdutoService produtoService;

  @RequestMapping(value = "/produto/all", method = RequestMethod.GET)
  public ResponseEntity find() {
    try {
      Iterable<Produto> result = produtoService.findAll();
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception ex) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/produto", method = RequestMethod.POST)
  public ResponseEntity save(@RequestParam("nome") String nome, @RequestParam("codigo") String codigo, @RequestParam("valor") Double valor) {
    try {
      Produto produto = new Produto(codigo, nome, valor);
      produtoService.save(produto);
      return new ResponseEntity<>(produto, HttpStatus.OK);
    } catch (Exception ex) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@RequestParam("nome") String nome, @PathVariable Long id) {
    Produto produto = produtoService.findOne(id);
    if (produto != null) {
      produto.setNome(nome);
      produtoService.save(produto);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable Long id) {
    try {
      produtoService.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception ex) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}