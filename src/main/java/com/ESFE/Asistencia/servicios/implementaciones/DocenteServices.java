package com.ESFE.Asistencia.servicios.implementaciones;

import com.ESFE.Asistencia.entidades.Docente;
import com.ESFE.Asistencia.entidades.Grupo;
import com.ESFE.Asistencia.repositorios.iDocenteRepository;
import com.ESFE.Asistencia.repositorios.iGrupoRepository;
import com.ESFE.Asistencia.servicios.interfaces.iDocenteServices;
import com.ESFE.Asistencia.servicios.interfaces.iGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DocenteServices implements iDocenteServices {

    @Autowired
    private iDocenteRepository docenteRepository;

    @Override
    public Page<Docente> BuscarTodosPaginados(Pageable pageable) {
        return docenteRepository.findAll(pageable);
    }

    @Override
    public List<Docente> ObtenerTodos() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docente> BuscarPorId(Integer id) {
        return docenteRepository.findById(id);
    }

    @Override
    public Docente CrearOeditar(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public void EliminarPorId(Integer id) {
        docenteRepository.deleteById(id);
    }
}
