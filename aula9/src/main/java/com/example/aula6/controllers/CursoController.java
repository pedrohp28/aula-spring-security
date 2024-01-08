package com.example.aula6.controllers;

import com.example.aula6.dto.CursoDto;
import com.example.aula6.dto.DadosCursoDTO;
import com.example.aula6.services.CursoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/curso")
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoService;

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Long inserir(@Valid @RequestBody CursoDto cursoDto) {
        return cursoService.salvar(cursoDto).getId();
    }

    @GetMapping
    public List<CursoDto> buscarCursos() {
        return cursoService.buscarTodos();
    }

    @GetMapping("{id}")
    public DadosCursoDTO buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        cursoService.excluir(id);
    }

    @PutMapping("{id}")
    public void editar(@PathVariable Long id, @RequestBody CursoDto dto) {
        cursoService.editar(id, dto);
    }

}
