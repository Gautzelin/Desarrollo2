package com.universidad.universidad.repository;

import com.universidad.universidad.entity.Curso;
import com.universidad.universidad.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Profesor findByNombre(String nombre);
    @Query("SELECT p FROM Profesor p")
    List<Profesor> obtenerTodosLosProfesores();

    @Query("SELECT p FROM Profesor p WHERE p.departamento.nombre = :nombreDepto")
    List<Profesor> buscarPorDepartamento(@Param("nombreDepto") String nombre);






}
