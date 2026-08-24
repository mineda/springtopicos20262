package br.gov.sp.cps.springtopicos20262.service;

import java.util.List;

import br.gov.sp.cps.springtopicos20262.entity.Curso;

public interface CursoService {

    public Curso cadastrar(Curso curso);

    public List<Curso> listar();

    public Curso buscarPorId(Long id);
    
}
