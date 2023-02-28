package com.accenture.capability.cursos.infra.inputadapter;

import com.accenture.capability.cursos.domain.model.Cursos;
import com.accenture.capability.cursos.infra.inputport.MetodosCursosPermitidos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping({"/", "/principalCursos"})
public class RestControllerCursos {

    @Autowired
    private MetodosCursosPermitidos metodosCursos;

    @GetMapping(value = "/listarCursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cursos> listarCursosController() {
        log.info("Ejecutando listarCursosController()");
        return metodosCursos.listarCursosPeticion();
    }

    @GetMapping( "/buscarCurso/{idCurso}")
    public ResponseEntity<Cursos> buscarIdCursoController(@PathVariable int idCurso) {
        log.info("Ejecutando buscarIdCursoController()");
        try {
            Cursos curso = metodosCursos.buscarCursoPeticion(idCurso);
            return new ResponseEntity<Cursos>(curso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/agregarCurso", produces = MediaType.APPLICATION_JSON_VALUE)
    public void agregarCursoController(@RequestBody Cursos curso){
        log.info("Ejecutando agregarCursoController");
        metodosCursos.agregarCursoPeticion(curso);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/actualizarCurso", produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarCursoController(@RequestBody Cursos curso){
        log.info("Ejecutando actualizarCursoController");
        metodosCursos.actualizarCursoPeticion(curso);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminarCurso/{idCurso}")
    public void eliminarCursoController(@PathVariable int idCurso) {
        log.info("Ejecutando eliminarCursoController");
        metodosCursos.eliminarCursoPeticion(idCurso);
    }

}
