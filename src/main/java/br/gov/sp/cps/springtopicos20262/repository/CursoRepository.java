package br.gov.sp.cps.springtopicos20262.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.cps.springtopicos20262.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
