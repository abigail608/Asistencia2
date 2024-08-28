package com.ESFE.Asistencia.repositorios;

import com.ESFE.Asistencia.entidades.DocenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iDocenteGrupoRepository extends JpaRepository<DocenteGrupo, Integer> {
    Page<DocenteGrupo> findByOrderByDocenteDesc(Pageable pageable);
}
