package br.com.alura.listavip.resource;

import br.com.alura.listavip.dto.ProdutoDTO;
import br.com.alura.listavip.model.Produto;
import br.com.alura.listavip.service.ProdutoService;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProdutoResource {

    /*
    @RequestParam("nome") String nome - Param -http://localhost:8080/produto?nome=hih&codigo=fgf&valor=12
    @PathVariable Long id - URL {id}  - http://localhost:8080/produto/1
    @RequestBody(required = true) Map<String, Object> corpo - BODY (Data)
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

    @RequestMapping(value = "/produto/all/json", method = RequestMethod.GET)
    public ResponseEntity findJson() {
      try {
        JSONObject jsonObjectResult = new JSONObject();
        List<ProdutoDTO>  produtoDTOS = new ArrayList<>();

        Iterable<Produto> result = produtoService.findAll();
        result.forEach(p -> {
          produtoDTOS.add(new ProdutoDTO(p));
        });
        jsonObjectResult.put("result", produtoDTOS);

        return new ResponseEntity<>(jsonObjectResult, HttpStatus.OK);
      } catch (Exception ex) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Map<String, Object> body) {
        try {
            Produto produto = new Produto(body.get("codigo").toString(), body.get("nome").toString(), 150d);
            produtoService.save(produto);
            return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Map<String, Object> body, @PathVariable Long id) {
        Produto produto = produtoService.findOne(id);
        if (produto != null) {
            produto.setNome(body.get("nome").toString());
            produtoService.save(produto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
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