package com.example.aula6.controllers;

import com.example.aula6.dto.AutenticacaoDto;
import com.example.aula6.dto.TokenDto;
import com.example.aula6.exceptions.RegraNegocioException;
import com.example.aula6.models.Usuario;
import com.example.aula6.security.JwtService;
import com.example.aula6.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UsuarioService usuarioService;
    private JwtService jwtService;

    public AuthController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping()
    public TokenDto autenticar(@RequestBody AutenticacaoDto
                                       autenticacao) {
        try {
            Usuario usuario = new Usuario(0, "",
                    autenticacao.getEmail(), autenticacao.getSenha(), "");
            UserDetails usuarioAutenticado =
                    usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDto(usuario.getEmail(), token);
        } catch (UsernameNotFoundException |
                 RegraNegocioException ex) {
            throw new
                    ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    ex.getMessage());
        }
    }
}
