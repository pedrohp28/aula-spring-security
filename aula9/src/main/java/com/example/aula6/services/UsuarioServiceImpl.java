package com.example.aula6.services;

import com.example.aula6.dto.UsuarioDto;
import com.example.aula6.exceptions.RegraNegocioException;
import com.example.aula6.models.Usuario;
import com.example.aula6.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public Usuario salvar(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setPerfil(dto.getPerfil());
        return usuarioRepository.save(usuario);
    }
    @Override
    public UsuarioDto obterUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).map(u -> {
                    return UsuarioDto
                            .builder()
                            .email(u.getEmail())
                            .perfil(u.getPerfil())
                            .build();
                })
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
    }
    @Override
    public List<UsuarioDto> obterUsuarios() {
        List<UsuarioDto> dados = usuarioRepository.findAll().stream().map(u -> {
            return UsuarioDto
                    .builder()
                    .email(u.getEmail())
                    .perfil(u.getPerfil())
                    .build();
        }).toList();
        return dados;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario =
                usuarioRepository.findByEmail(username);
        String[] roles = usuario.getPerfil() == "Administrador" ? new
                String[] { "ADMIN", "USER" }
                : new String[] { "USER" };
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }
    @Override
    public UserDetails autenticar(Usuario usuario) {
        UserDetails user =
                loadUserByUsername(usuario.getEmail());
        boolean senhaOK =
                passwordEncoder.matches(usuario.getSenha(),
                        user.getPassword());
        if (senhaOK) {
            return user;
        }
        throw new RegraNegocioException("Senha inválida");
    }
}
