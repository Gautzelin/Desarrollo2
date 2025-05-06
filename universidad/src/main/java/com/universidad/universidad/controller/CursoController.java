package com.universidad.universidad.controller;

import com.universidad.universidad.entity.Curso;
import com.universidad.universidad.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoRepository cursoRepository;

    // ✅ Buscar curso por nombre (por ejemplo: "Programación I")
    @GetMapping("/por-nombre")
    public Curso buscarPorNombre(@RequestParam String nombre) {
        return cursoRepository.findByNombre(nombre);
    }

    // ✅ Buscar todos los cursos dictados por un profesor según su ID
    @GetMapping("/por-profesor")
    public List<Curso> cursosPorProfesor(@RequestParam Long idProfesor) {
        return cursoRepository.cursosPorProfesor(idProfesor);
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoRepository.obtenerTodosLosCursos();
    }
}
