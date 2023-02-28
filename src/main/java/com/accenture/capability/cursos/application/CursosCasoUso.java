package com.accenture.capability.cursos.application;

import com.accenture.capability.cursos.domain.model.Cursos;
import com.accenture.capability.cursos.infra.inputport.MetodosCursosPermitidos;
import com.accenture.capability.cursos.infra.outputport.MetodosRepositoryCursoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosCasoUso implements MetodosCursosPermitidos {

    @Autowired
    private MetodosRepositoryCursoPort metodosRepositoryCursoPort;

    @Override
    public List<Cursos> listarCursosPeticion() {
        return metodosRepositoryCursoPort.listarCursosDeRepository();
    }

    @Override
    public Cursos buscarCursoPeticion(int idCurso) {
        return metodosRepositoryCursoPort.buscarCursoDeRepository(idCurso);
    }

    @Override
    public void agregarCursoPeticion(Cursos curso) {
        metodosRepositoryCursoPort.agregarCursoEnRepository(curso);
    }

    @Override
    public void actualizarCursoPeticion(Cursos curso) {
        metodosRepositoryCursoPort.actualizarCursoEnRepository(curso);
    }

    @Override
    public void eliminarCursoPeticion(int idCurso) {
        metodosRepositoryCursoPort.eliminarCursoDeRepository(idCurso);
    }
}
