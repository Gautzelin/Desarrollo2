package com.universidad.universidad;

import com.universidad.universidad.repository.CursoRepository;
import com.universidad.universidad.repository.EstudianteRepository;
import com.universidad.universidad.repository.ProfesorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniversidadApplicationTests {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	EstudianteRepository estudianteRepository;
	@Autowired
	ProfesorRepository profesorRepository;
	@Test
	void contextLoads() {
	}

}
