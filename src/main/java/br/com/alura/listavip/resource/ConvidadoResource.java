package br.com.alura.listavip.resource;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.model.Produto;
import br.com.alura.listavip.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class ConvidadoResource {

    @Autowired
    private ConvidadoService service;

    @RequestMapping("/convidado/find")
    @ResponseBody
    public List<Convidado> find() {
        // List<Convidado> result = repository.findByNome("Luis");
        // List<Convidado> result = repository.findByNomeOrTelefone("Luis", "123456");
        List<Convidado> result = service.findByNomeOrTelefoneOrEmail("Luis", "123456", "springbootalura@gmail.com");
        for (Convidado convidado : result) {
            System.out.println(convidado.getNome());
        }
        return result;
    }
}