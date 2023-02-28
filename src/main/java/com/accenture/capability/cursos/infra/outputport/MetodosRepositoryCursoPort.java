package com.accenture.capability.cursos.infra.outputport;

import com.accenture.capability.cursos.domain.model.Cursos;

import java.util.List;

public interface MetodosRepositoryCursoPort {

    List<Cursos> listarCursosDeRepository();

    Cursos buscarCursoDeRepository(int idCurso);

    void agregarCursoEnRepository(Cursos curso);

    void actualizarCursoEnRepository(Cursos curso);

    void eliminarCursoDeRepository(int idCurso);

}
