package br.com.alura.listavip.resource;

import br.com.alura.listavip.model.Autor;
import br.com.alura.listavip.model.Produto;
import br.com.alura.listavip.service.AutorService;
import br.com.alura.listavip.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class AutorResource {

    /*
    @RequestParam("nome") String nome - Param -http://localhost:8080/produto?nome=hih&codigo=fgf&valor=12
    @PathVariable Long id - URL {id}  - http://localhost:8080/produto/1
    @RequestBody(required = true) Map<String, Object> corpo - BODY (Data)
    */

    @Autowired
    private AutorService autorService;

    @RequestMapping(value = "/api/autores", method = RequestMethod.GET)
    public ResponseEntity find() {
        try {
            Iterable<Autor> result = autorService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/api/autores", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Map<String, Object> body) {
        try {
            String nome = body.get("nome").toString();
            String email = body.get("email").toString();
            String senha = body.get("senha").toString();
            if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty())
                autorService.save(new Autor(nome, email, senha));
            return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
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
    */
}