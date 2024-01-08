package com.example.aula6.repositories;

import com.example.aula6.models.CategoriaCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Long> {

    @Query("select cc from CategoriaCurso cc left join fetch cc.cursos c where cc.id = :id ")
    CategoriaCurso findCategoriaCursoFetchCursos(@Param("id") Long id);
}


