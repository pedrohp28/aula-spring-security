package com.example.aula6.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String nome;
    private String email;
    private String senha;
    private String perfil;
}
