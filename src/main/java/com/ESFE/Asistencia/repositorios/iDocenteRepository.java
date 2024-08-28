package com.ESFE.Asistencia.repositorios;
import com.ESFE.Asistencia.entidades.Docente;
import com.ESFE.Asistencia.entidades.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iDocenteRepository extends JpaRepository<Docente,Integer>{

    List<Docente> findAll();
}
