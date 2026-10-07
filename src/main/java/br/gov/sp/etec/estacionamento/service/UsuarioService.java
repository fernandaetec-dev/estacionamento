// 26/08/2026

package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.model.Usuario;
import java.util.List;

// Uma interface dita as regras, como se fosse um contrato
public interface UsuarioService {

    String cadastroUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    String atualizarUsuario(Usuario usuario);
    String deletarUsuario(Long id);
    Usuario buscaUsuarioPorEmail(String email);
}
