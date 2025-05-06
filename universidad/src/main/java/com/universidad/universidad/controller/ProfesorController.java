package com.universidad.universidad.controller;

import com.universidad.universidad.entity.Profesor;
import com.universidad.universidad.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorRepository profesorRepository;

    // Obtener todos los profesores (JPQL sin parámetro)
    @GetMapping
    public List<Profesor> listar() {
        return profesorRepository.obtenerTodosLosProfesores();
    }

    // Buscar profesores por nombre del departamento (JPQL con parámetro)
    @GetMapping("/por-departamento")
    public List<Profesor> buscarPorDepartamento(@RequestParam String nombre) {
        return profesorRepository.buscarPorDepartamento(nombre);
    }
}
