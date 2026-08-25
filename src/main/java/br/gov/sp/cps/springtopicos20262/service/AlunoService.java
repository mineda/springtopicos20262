package br.gov.sp.cps.springtopicos20262.service;

import java.util.List;

import br.gov.sp.cps.springtopicos20262.entity.Aluno;

public interface AlunoService {

    public Aluno cadastrar(Aluno aluno);

    public List<Aluno> listar();

    public Aluno buscarPorId(Long id);
    
}
