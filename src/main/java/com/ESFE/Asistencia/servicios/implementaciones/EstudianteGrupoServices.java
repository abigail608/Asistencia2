package com.ESFE.Asistencia.servicios.implementaciones;

import com.ESFE.Asistencia.entidades.EstudianteGrupo;
import com.ESFE.Asistencia.repositorios.iEstudianteGrupoRepository;
import com.ESFE.Asistencia.servicios.interfaces.iEstudianteGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteGrupoServices implements iEstudianteGrupoServices {

    @Autowired
    private iEstudianteGrupoRepository estudianteGrupoRepository;

    @Override
    public Page<EstudianteGrupo> BuscarTodosPaginados(Pageable pageable) {
        return estudianteGrupoRepository.findByOrderByEstudianteDesc(pageable);
    }

    @Override
    public List<EstudianteGrupo> ObtenerTodos() {
        return estudianteGrupoRepository.findAll() ;
    }

    @Override
    public Optional<EstudianteGrupo> BuscarPorId(Integer id) {
        return estudianteGrupoRepository.findById(id);
    }

    @Override
    public EstudianteGrupo CrearOeditar(EstudianteGrupo estudianteGrupo) {
        return estudianteGrupoRepository.save(estudianteGrupo);
    }

    @Override
    public void EliminarPorId(Integer id) {
        estudianteGrupoRepository.deleteById(id);
    }
}
