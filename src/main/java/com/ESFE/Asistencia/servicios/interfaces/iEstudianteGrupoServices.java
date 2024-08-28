package com.ESFE.Asistencia.servicios.interfaces;

import com.ESFE.Asistencia.entidades.EstudianteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface iEstudianteGrupoServices {
    Page<EstudianteGrupo> BuscarTodosPaginados(Pageable pageable);
    List<EstudianteGrupo> ObtenerTodos();
    Optional<EstudianteGrupo> BuscarPorId(Integer id);
    EstudianteGrupo CrearOeditar(EstudianteGrupo estudianteGrupo);
    void EliminarPorId(Integer id);
}
