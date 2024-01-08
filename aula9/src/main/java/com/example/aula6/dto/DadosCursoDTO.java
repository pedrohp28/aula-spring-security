package com.example.aula6.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosCursoDTO {
    private Long id;
    private String nome;
    private int cargaHoraria;
    private CategoriaCursoDTO categoria;
}
