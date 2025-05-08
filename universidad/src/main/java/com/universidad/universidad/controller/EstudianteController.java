package com.universidad.universidad.controller;

import com.universidad.universidad.entity.Estudiante;
import com.universidad.universidad.repository.CursoRepository;
import com.universidad.universidad.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;
    @GetMapping("/estudiantes")
    public List<Estudiante> findByNombre(@RequestParam String nombre) {
        return estudianteRepository.findByNombre(nombre);
    }
    @GetMapping("/estudiantes/email")
    public Estudiante buscarPorEmail(@RequestParam String email) {
        return estudianteRepository.buscarPorEmail(email);
    }

    @GetMapping("/estudiantes/todos")
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.obtenerTodos();
    }
}
