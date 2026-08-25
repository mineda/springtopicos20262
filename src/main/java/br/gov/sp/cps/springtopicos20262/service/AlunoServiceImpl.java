package br.gov.sp.cps.springtopicos20262.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springtopicos20262.entity.Aluno;
import br.gov.sp.cps.springtopicos20262.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repo;

    public AlunoServiceImpl(AlunoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Aluno cadastrar(Aluno aluno) {
        if(aluno == null ||
                aluno.getId() != null ||
                aluno.getNome() == null || 
                aluno.getNome().isBlank() ||
                aluno.getRa() == null || 
                aluno.getRa() <= 0L) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados do aluno inválidos");
        }
        return repo.save(aluno);
    }

    @Override
    public List<Aluno> listar() {
        return repo.findAll();
    }

    @Override
    public Aluno buscarPorId(Long id) {
        if(id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O id do aluno não pode ser nulo");
        }
        return repo.findById(id).
            orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }
    
}
