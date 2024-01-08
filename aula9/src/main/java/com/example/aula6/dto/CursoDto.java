package com.example.aula6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CursoDto {
    private Long id;
    private String nome;
    private int cargaHoraria;
    private Long categoriaCursoId;
}
