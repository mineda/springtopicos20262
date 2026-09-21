package br.gov.sp.cps.springtopicos20262.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.cps.springtopicos20262.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    public List<Trabalho> findByTituloContainingIgnoreCaseAndAlunoRa(String titulo, Long ra);

    @Query("SELECT t FROM Trabalho t JOIN t.aluno a WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')) AND a.ra = :ra")
    public List<Trabalho> buscarPorRaAlunoETitulo(Long ra, String titulo);
}
