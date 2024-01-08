package com.example.aula6.services;

import com.example.aula6.dto.CategoriaCursoDTO;
import com.example.aula6.dto.CursoDto;
import com.example.aula6.dto.DadosCursoDTO;
import com.example.aula6.exceptions.RegraNegocioException;
import com.example.aula6.models.CategoriaCurso;
import com.example.aula6.models.Curso;
import com.example.aula6.repositories.CategoriaCursoRepository;
import com.example.aula6.repositories.CursoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;
    private final CategoriaCursoRepository categoriaCursoRepository;
    @Override
    public Curso salvar(CursoDto cursoDto) {
        CategoriaCurso categ = categoriaCursoRepository.findById(
                cursoDto.getCategoriaCursoId()).orElseThrow(
                () -> new RegraNegocioException("Código da categoria não encontrada")
        );
        Curso c = new Curso();
        c.setNome(cursoDto.getNome());
        c.setCargaHoraria(cursoDto.getCargaHoraria());
        c.setCategoriaCurso(categ);

        return cursoRepository.save(c);
    }

    @Override
    public List<CursoDto> buscarTodos() {
        List<CursoDto> cursos = cursoRepository.findAll()
                .stream().map((Curso c) -> {
                    return CursoDto.builder()
                            .id(c.getId())
                            .nome(c.getNome())
                            .cargaHoraria(c.getCargaHoraria())
                            .categoriaCursoId(c.getCategoriaCurso() == null ? null : c.getCategoriaCurso().getId())
                            .build();
                }).collect(Collectors.toList());
        return cursos;
    }

    @Override
    public DadosCursoDTO buscarPorId(Long id) {
        return cursoRepository.findById(id).map((Curso c) -> {
            return DadosCursoDTO
                    .builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .cargaHoraria(c.getCargaHoraria())
                    .categoria(c.getCategoriaCurso() != null ?
                            CategoriaCursoDTO.builder()
                            .id(c.getCategoriaCurso().getId())
                            .nome(c.getCategoriaCurso().getNome()
                            ).build() : null
                    ).build();
        }).orElseThrow(() -> new RegraNegocioException("Curso não encontrado com o ID fornecido"));
    }

    @Override
    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, CursoDto dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Código usuário não encontrado."));
                        CategoriaCurso categoriaCurso =
                        categoriaCursoRepository.findById(dto.getCategoriaCursoId())
                                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));
                        curso.setNome(dto.getNome());
                        curso.setCargaHoraria(dto.getCargaHoraria());
                        curso.setCategoriaCurso(categoriaCurso);
        cursoRepository.save(curso);
    }

}
