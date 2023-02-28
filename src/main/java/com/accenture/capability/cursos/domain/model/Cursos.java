package com.accenture.capability.cursos.domain.model;

import lombok.Getter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int idCurso;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Column(name = "tipo_curso")
    private String tipoCurso;
    @Column(name = "nombre_profesor")
    private String nombreProfesor;
    @Column(name = "numero_alumnos")
    private int numeroAlumnos;
    @Column(name = "numero_lecciones")
    private int numeroLecciones;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(Integer numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public int getNumeroLecciones() {
        return numeroLecciones;
    }

    public void setNumeroLecciones(Integer numeroLecciones) {
        this.numeroLecciones = numeroLecciones;
    }
}