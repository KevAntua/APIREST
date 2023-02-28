package com.accenture.capability.cursos.infra.outputadapter;

import com.accenture.capability.cursos.domain.model.Cursos;
import com.accenture.capability.cursos.infra.outputport.CursosJPARepository;
import com.accenture.capability.cursos.infra.outputport.MetodosRepositoryCursoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBHRepository implements MetodosRepositoryCursoPort {

    @Autowired
    private CursosJPARepository cursosJPARepository;

    @Override
    public List<Cursos> listarCursosDeRepository() {
        return cursosJPARepository.findAll();
    }

    @Override
    public Cursos buscarCursoDeRepository(int idCurso) {
        return cursosJPARepository.findById(idCurso).get();
    }

    @Override
    public void agregarCursoEnRepository(Cursos curso) {
        cursosJPARepository.save(curso);
    }

    @Override
    public void actualizarCursoEnRepository(Cursos curso) {
        Cursos cursoexistente = cursosJPARepository.findById(curso.getIdCurso()).orElse(null);
        cursoexistente.setNombreCurso(curso.getNombreCurso());
        cursoexistente.setTipoCurso(curso.getTipoCurso());
        cursoexistente.setNombreProfesor(curso.getNombreProfesor());
        cursoexistente.setNumeroAlumnos(curso.getNumeroAlumnos());
        cursoexistente.setNumeroLecciones(curso.getNumeroLecciones());
        cursosJPARepository.save(cursoexistente);
    }

    @Override
    public void eliminarCursoDeRepository(int idCurso) {
        cursosJPARepository.deleteById(idCurso);
    }
}
