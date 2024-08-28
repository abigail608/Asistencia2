package com.ESFE.Asistencia.servicios.interfaces;

import com.ESFE.Asistencia.entidades.DocenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface iDocenteGrupoService {

    Page<DocenteGrupo> BuscarTodosPaginados(Pageable pageable);
    List<DocenteGrupo> ObtenerTodos();
    Optional<DocenteGrupo> BuscarPorId(Integer id);
    DocenteGrupo CrearOeditar(DocenteGrupo docenteGrupo);
    void EliminarPorId(Integer id);
}
