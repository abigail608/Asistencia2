package com.ESFE.Asistencia.repositorios;

import com.ESFE.Asistencia.entidades.EstudianteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iEstudianteGrupoRepository extends JpaRepository<EstudianteGrupo, Integer> {
    Page<EstudianteGrupo> findByOrderByEstudianteDesc(Pageable pageable);
}
