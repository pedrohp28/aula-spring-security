package com.example.aula6.services;

import com.example.aula6.dto.CursoDto;
import com.example.aula6.dto.DadosCursoDTO;
import com.example.aula6.models.Curso;

import java.util.List;

public interface CursoService {
    Curso salvar(CursoDto cursoDto);
    List<CursoDto> buscarTodos();
    DadosCursoDTO buscarPorId(Long id);
    void excluir(Long id);
    void editar(Long id, CursoDto dto);
}
