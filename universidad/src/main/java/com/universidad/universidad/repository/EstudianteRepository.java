package com.universidad.universidad.repository;

import com.universidad.universidad.entity.Estudiante;
import com.universidad.universidad.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByNombre(String nombre);
    @Query("SELECT e FROM Estudiante e")
    List<com.universidad.universidad.entity.Estudiante> obtenerTodos();

    @Query("SELECT e FROM Estudiante e WHERE e.email = ?1")
    Estudiante buscarPorEmail(String email);

    @Query("SELECT m FROM Matricula m WHERE m.estudiante.id = :idEstudiante")
    List<Matricula> buscarMatriculasPorEstudiante(@Param("idEstudiante") Long idEstudiante);


}
