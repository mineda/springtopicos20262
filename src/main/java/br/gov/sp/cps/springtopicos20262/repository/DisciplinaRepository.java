package br.gov.sp.cps.springtopicos20262.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.cps.springtopicos20262.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    public Optional<Disciplina> findByCodigo(String codigo);

    @Query("SELECT d FROM Disciplina d WHERE d.codigo = :codigo")
    public Optional<Disciplina> buscarPeloCodigo(String codigo);

    public List<Disciplina> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT d FROM Disciplina d WHERE LOWER(d.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    public List<Disciplina> buscarPeloNome(String nome);

    public List<Disciplina> findByAlunosNomeContainingIgnoreCase(String nomeAluno);

    @Query("SELECT d FROM Disciplina d JOIN d.alunos a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nomeAluno, '%'))")
    public List<Disciplina> buscarPorNomeAluno(String nomeAluno);

    public List<Disciplina> findByCargaHorariaGreaterThanEqualOrNomeContainingIgnoreCase(Integer cargaHoraria, String nome);

    @Query("SELECT d FROM Disciplina d WHERE d.cargaHoraria >= :cargaHoraria OR LOWER(d.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    public List<Disciplina> buscarPorCargaHorariaMaiorIgualOuNome(Integer cargaHoraria, String nome);
}
