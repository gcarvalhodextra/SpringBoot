package br.com.alura.listavip.controller;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.model.Product;
import br.com.alura.listavip.service.ConvidadoService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
  public String save(@RequestParam("nome") String nome, @RequestParam("email") String email,
    @RequestParam("telefone") String telefone, Model model) {
    Convidado convidado = new Convidado(nome, email, telefone);
    service.save(convidado);
    service.sendMail(nome, email);

    reload(model);

    return "listaconvidados";
  }

  private void reload(Model model) {
    Iterable<Convidado> convidados = service.findAll();
    // Enviando a lista para a View
    model.addAttribute("convidados", convidados);
  }

  @RequestMapping("/test/find")
  public String find() {
    // List<Convidado> result = repository.findByNome("Luis");
    // List<Convidado> result = repository.findByNomeOrTelefone("Luis", "123456");
    List<Convidado> result = service.findByNomeOrTelefoneOrEmail("Luis", "123456", "springbootalura@gmail.com");
    for (Convidado convidado : result) {
      System.out.println(convidado.getNome());
    }
    return "index";
  }

  @RequestMapping("/products/all")
  @ResponseBody
  public List<Product> getAll() {
    Product product01 = new Product(1L, "1", Arrays.asList("1.0.0"));
    Product product02 = new Product(2L, "2", Arrays.asList("1.0.0", "1.0.1"));
    return Arrays.asList(product01, product02);
  }
}