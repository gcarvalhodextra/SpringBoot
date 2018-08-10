package br.com.alura.listavip.controller;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvidadoController {

    // Como ele � um bean do Spring precisa injeta-lo
    @Autowired
    private ConvidadoService service;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/listaconvidados")
    public String listaConvidados(Model model) {
        reload(model);
        return "listaconvidados";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("telefone") String telefone, Model model) {
        if (!nome.isEmpty() && !email.isEmpty()) {
            service.save(new Convidado(nome, email, telefone));
            service.sendMail(nome, email);
            reload(model);
        }
        reload(model);
        return "listaconvidados";
    }

    private void reload(Model model) {
        Iterable<Convidado> convidados = service.findAll();
        // Enviando a lista para a View
        model.addAttribute("convidados", convidados);
    }
}