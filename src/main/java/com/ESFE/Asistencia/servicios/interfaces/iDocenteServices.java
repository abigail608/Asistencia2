package com.ESFE.Asistencia.servicios.interfaces;

import com.ESFE.Asistencia.entidades.Docente;
import com.ESFE.Asistencia.entidades.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
public interface iDocenteServices {
    Page<Docente> BuscarTodosPaginados(Pageable pageable);
    List<Docente> ObtenerTodos();
    Optional<Docente> BuscarPorId(Integer id);
    Docente CrearOeditar(Docente docente);
    void EliminarPorId(Integer id);
}
