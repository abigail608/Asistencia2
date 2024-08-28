package com.ESFE.Asistencia.servicios.implementaciones;
import com.ESFE.Asistencia.entidades.Estudiante;
import com.ESFE.Asistencia.repositorios.iEstudianteRepository;
import com.ESFE.Asistencia.servicios.interfaces.iEstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteServices implements iEstudianteServices {
    @Autowired
    private iEstudianteRepository estudianteRepository;

    @Override
    public Page<Estudiante> BuscarTodosPaginados(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    @Override
    public List<Estudiante> ObtenerTodos() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> BuscarPorId(Integer id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante CrearOeditar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void EliminarPorId(Integer id) {
        estudianteRepository.deleteById(id);
    }

}
