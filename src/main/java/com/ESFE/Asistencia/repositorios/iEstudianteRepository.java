package com.ESFE.Asistencia.repositorios;
import com.ESFE.Asistencia.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface iEstudianteRepository extends JpaRepository<Estudiante,Integer>{

    List<Estudiante> findAll();
}

