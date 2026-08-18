package br.gov.sp.cps.springtopicos20262.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.cps.springtopicos20262.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
}
