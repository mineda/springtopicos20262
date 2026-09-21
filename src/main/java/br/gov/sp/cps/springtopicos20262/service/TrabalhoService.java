package br.gov.sp.cps.springtopicos20262.service;

import java.util.List;

import br.gov.sp.cps.springtopicos20262.entity.Trabalho;

public interface TrabalhoService {

    public List<Trabalho> listarTodos();

    public Trabalho cadastrar(Trabalho trabalho);

    public List<Trabalho> buscarPorRaAlunoETitulo(Long ra, String titulo);
    
}
