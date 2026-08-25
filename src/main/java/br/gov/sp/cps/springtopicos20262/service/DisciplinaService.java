package br.gov.sp.cps.springtopicos20262.service;

import java.util.List;

import br.gov.sp.cps.springtopicos20262.entity.Disciplina;

public interface DisciplinaService {

    public Disciplina cadastrar(Disciplina disciplina);

    public List<Disciplina> listar();

    public Disciplina buscarPorId(Long id);  
    
    public void matricularAluno(Long disciplinaId, Long alunoId);
    
}
