package com.example.aula6;

import com.example.aula6.models.CategoriaCurso;
import com.example.aula6.models.Curso;
import com.example.aula6.repositories.CategoriaCursoRepository;
import com.example.aula6.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Aula6Application {

    public static void main(String[] args) {
        SpringApplication.run(Aula6Application.class, args);
    }

//    @Bean
//    public CommandLineRunner init(@Autowired CursoRepository cursoRepository,
//                                  @Autowired CategoriaCursoRepository categoriaCursoRepository) {
//        return args -> {
//            cursoRepository.save(
//                    new Curso(null, "teste01", 2000));
//            cursoRepository.save(
//                    new Curso(null, "teste02", 2050));
//            List<Curso> listaCursos = cursoRepository.findAll();
//            listaCursos.forEach(System.out::println);
//
//            listaCursos = cursoRepository.findByNomeLike("%2%");
//            listaCursos.forEach(System.out::println);
//
//            CategoriaCurso c1 = new CategoriaCurso(null, "TI");
//            categoriaCursoRepository.save(c1);
//
//            //c1 = categoriaCursoRepository.obterPorNome("TI").get(0);
//
//            listaCursos.get(0).setCategoriaCurso(c1);
//            cursoRepository.save(listaCursos.get(0));
//
//            System.out.println("-".repeat(30));
////            List<CategoriaCurso> categs = categoriaCursoRepository.findAll();
////            for (CategoriaCurso ca : categs) {
////                System.out.println(ca.getId() + " - " + ca.getNome() + "qtde cursos: " +
////                        ca.getCursos().size());
////            }
//            CategoriaCurso cc = categoriaCursoRepository.findCategoriaCursoFetchCursos((long) 1);
//            System.out.println(cc.getCursos().size());
//
//        };
//    }
}
