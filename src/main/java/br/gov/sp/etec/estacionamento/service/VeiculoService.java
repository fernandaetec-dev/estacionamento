// 09/09/2026

package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etec.estacionamento.model.Veiculo;

import java.util.List;

public interface VeiculoService {

    void cadastrarVeiculo(Veiculo veiculo);
    List<VeiculoEntity> listaVeiculo();
    Boolean deletarVeiculo(Long id);
    VeiculoEntity atualizarVeiculo(VeiculoEntity veiculo);
    VeiculoEntity buscaVeiculoPorId(Long id);
}
