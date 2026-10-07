// 09/09/2026

// 16/09/2026

package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etec.estacionamento.model.Veiculo;
import br.gov.sp.etec.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    VeiculoRepository repository;

    @Override
    public VeiculoEntity atualizarVeiculo(VeiculoEntity veiculo) {
        return repository.save(veiculo);
    }

    @Override
    public VeiculoEntity buscaVeiculoPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Boolean deletarVeiculo(Long id) {

        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<VeiculoEntity> listaVeiculo() {
        List<VeiculoEntity> veiculos = repository.findAll();
        return veiculos;
    }

    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {
        repository.save(toEntity(veiculo));
    }

    // Criar um método que retorne um VeiculoEntity para mapear um veículo para VeículoEntity

    private VeiculoEntity toEntity(Veiculo veiculo) {

        VeiculoEntity entity = new VeiculoEntity();
        entity.setHoraEntrada(LocalDateTime.now());
        entity.setPlaca(veiculo.getPlaca());
        entity.setCor(veiculo.getCor());
        entity.setModelo(veiculo.getModelo());
        entity.setObservacao(veiculo.getObservacao());

        return entity;
    }

    private List<Veiculo> toListVeiculo(List<VeiculoEntity> entities) {
        List<Veiculo> veiculos = new ArrayList<>();

        for(VeiculoEntity v : entities) {

            Veiculo veiculo = new Veiculo();

            veiculo.setPlaca(v.getPlaca());
            veiculo.setCor(v.getCor());
            veiculo.setModelo(v.getModelo());
            veiculo.setObservacao(v.getObservacao());

            veiculos.add(veiculo);
        }

        return veiculos;
    }
}
