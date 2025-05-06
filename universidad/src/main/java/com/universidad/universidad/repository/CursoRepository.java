package com.universidad.universidad.repository;

import com.universidad.universidad.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNombre(String nombre);

    @Query("SELECT c FROM Curso c WHERE c.profesor.id = :idProfesor")
    List<Curso> cursosPorProfesor(@Param("idProfesor") Long id);

    @Query("SELECT c FROM Curso c")
    List<Curso> obtenerTodosLosCursos();
}
