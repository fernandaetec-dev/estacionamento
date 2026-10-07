// 26/08/2026

package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etec.estacionamento.model.Usuario;
import br.gov.sp.etec.estacionamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public String cadastroUsuario(Usuario usuario) {

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setTelefone(usuario.getTelefone());
        usuarioEntity.setData(usuario.getData());

        repository.save(usuarioEntity);

        return "Usuário cadastrado com sucesso.";
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }

    @Override
    public String atualizarUsuario(Usuario usuario) {
        return "Usuario atualizado com sucesso.";
    }

    @Override
    public String deletarUsuario(Long id) {
        return "Usuario deletado com sucesso.";
    }

    @Override
    public Usuario buscaUsuarioPorEmail(String email) {
        UsuarioEntity entity = repository.findByEmail(email);
        Usuario user = toUsuario(entity);
        return user;
    }

    private Usuario toUsuario(UsuarioEntity entity) {
        Usuario usuario = new Usuario();

        usuario.setNome(entity.getNome());
        usuario.setCpf(entity.getCpf());
        usuario.setEmail(entity.getEmail());
        usuario.setSenha(entity.getSenha());
        usuario.setTelefone(entity.getTelefone());
        usuario.setData(entity.getData());

        return usuario;
    }
}
