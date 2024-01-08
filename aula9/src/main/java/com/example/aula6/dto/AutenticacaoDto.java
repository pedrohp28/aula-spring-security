package com.example.aula6.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutenticacaoDto {
    private String email;
    private String senha;
}
