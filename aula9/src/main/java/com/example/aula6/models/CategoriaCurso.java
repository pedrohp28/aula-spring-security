package com.example.aula6.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class CategoriaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoriaCurso", fetch = FetchType.EAGER)
    private List<Curso> cursos;

    public CategoriaCurso() {
    }

    public CategoriaCurso(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaCurso(Long id, String nome, List<Curso> cursos) {
        this.id = id;
        this.nome = nome;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "CategoriaCurso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
