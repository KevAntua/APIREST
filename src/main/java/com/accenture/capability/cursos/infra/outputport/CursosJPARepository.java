package com.accenture.capability.cursos.infra.outputport;

import com.accenture.capability.cursos.domain.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosJPARepository extends JpaRepository <Cursos, Integer> {
}
