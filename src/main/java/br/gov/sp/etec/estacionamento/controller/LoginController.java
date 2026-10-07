package br.gov.sp.etec.estacionamento.controller;

import br.gov.sp.etec.estacionamento.model.Usuario;
import br.gov.sp.etec.estacionamento.service.UsuarioService;
import br.gov.sp.etec.estacionamento.service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// localhost:8080
// localhost:8080/h2-console

@Controller

public class LoginController {

    @Autowired
    UsuarioService service;

    @Autowired
    VeiculoService veiculoService;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/") // Consulta de informação, abre sempre no index ("/")
    public String index() { return "login"; }

    @GetMapping("/cadastro")
    public String cadastrar(){ return "cadastro"; }

    @PostMapping("/efetuar_cadastro")
    public String efetuarCadastro(Usuario usuario) {
        log.info(usuario.toString());
        service.cadastroUsuario(usuario);
        return "cadastro_sucesso";
    }

    @PostMapping("/autenticar")
    public String autenticar(String email, String senha, Model model) {

        Usuario x = service.buscaUsuarioPorEmail(email);

        if (x != null && senha.equals(x.getSenha())) {

            // 01/10/2026
            var veiculos = veiculoService.listaVeiculo();
            model.addAttribute("veiculos", veiculos);
            return "painel";
        } else {

            return "erro";
        }
    }
}

/*
            // CRUD \\
    Create, Read, Update, Delete

 */