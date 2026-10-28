// 16/06/2026

package br.gov.sp.etec.estacionamento.controller;

import br.gov.sp.etec.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etec.estacionamento.model.Veiculo;
import br.gov.sp.etec.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("veiculo") // Para generalizar um caminho que é repetido muitas vezes

public class VeiculoController {

    @Autowired
    VeiculoService service;

    @PostMapping("cadastrar")
    public String cadastrar(Veiculo w, Model model) {
        service.cadastrarVeiculo(w);
        var veiculos = service.listaVeiculo();
        model.addAttribute("veiculos", veiculos);
        return "painel";
    }

    @GetMapping("registrar_entrada")
    public String registrarEntrada() {
        return "registrar_entrada";
    }

    @GetMapping("registrar_saida")
    public String registrarSaida(Model model) {

        var veiculos = service.listaVeiculo();

        model.addAttribute("veiculos",veiculos);

        return  "registrar_saida";
    }

    @GetMapping("saida/{id}")
    public String getVeiculo(Model model, @PathVariable Long id) {

        service.registrarSaida(id);

        var veiculos = service.listaVeiculo();

        model.addAttribute("veiculos", veiculos);

/*
        VeiculoEntity veiculo = service.buscaVeiculoPorId(id);

        model.addAttribute("veiculo", veiculo);
*/
        return "redirect:/veiculo/registrar_saida";
    }
}