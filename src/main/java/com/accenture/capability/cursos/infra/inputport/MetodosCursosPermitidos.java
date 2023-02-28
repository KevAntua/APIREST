package com.accenture.capability.cursos.infra.inputport;

import com.accenture.capability.cursos.domain.model.Cursos;

import java.util.List;
import java.util.Optional;

public interface MetodosCursosPermitidos {
    List<Cursos> listarCursosPeticion();

    Cursos buscarCursoPeticion(int idCurso);

    void agregarCursoPeticion(Cursos curso);

    void actualizarCursoPeticion(Cursos curso);

    void eliminarCursoPeticion(int idCurso);
}
