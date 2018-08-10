package br.com.alura.listavip.resource;

import br.com.alura.listavip.model.Produto;
import br.com.alura.listavip.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/produto/all")
    @ResponseBody
    public Iterable<Produto> find() {
        return produtoService.findAll();
    }
}