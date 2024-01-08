package com.example.aula6.services;

import com.example.aula6.dto.UsuarioDto;
import com.example.aula6.models.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioService {
    Usuario salvar(UsuarioDto dto);
    UsuarioDto obterUsuarioPorId(Integer id);
    List<UsuarioDto> obterUsuarios();
    UserDetails autenticar(Usuario usuario);
}
