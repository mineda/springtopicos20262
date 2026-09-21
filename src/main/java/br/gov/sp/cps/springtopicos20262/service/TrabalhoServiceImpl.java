package br.gov.sp.cps.springtopicos20262.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springtopicos20262.entity.Trabalho;
import br.gov.sp.cps.springtopicos20262.repository.TrabalhoRepository;

@Service
public class TrabalhoServiceImpl implements TrabalhoService {

    private final TrabalhoRepository repo;

    private final AlunoService alunoService;

    public TrabalhoServiceImpl(TrabalhoRepository repo, AlunoService alunoService) {
        this.repo = repo;
        this.alunoService = alunoService;
    }

    @Override
    public List<Trabalho> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Trabalho cadastrar(Trabalho trabalho) {
        if(trabalho == null ||
            trabalho.getId() != null ||
            trabalho.getTitulo() == null || 
            trabalho.getTitulo().isBlank() ||
            trabalho.getAluno() == null ||
            trabalho.getAluno().getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
            }
            if(trabalho.getDataHoraEntrega() == null) {
                trabalho.setDataHoraEntrega(LocalDateTime.now());
            }
            trabalho.setAluno(alunoService.buscarPorId(trabalho.getAluno().getId()));
            return repo.save(trabalho);
    }

    @Override
    public List<Trabalho> buscarPorRaAlunoETitulo(Long ra, String titulo) {
        if(ra == null || ra <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RA inválido!"); 
        }
        return repo.buscarPorRaAlunoETitulo(ra, titulo);
    }
    
}
