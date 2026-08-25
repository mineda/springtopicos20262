package br.gov.sp.cps.springtopicos20262.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springtopicos20262.entity.Aluno;
import br.gov.sp.cps.springtopicos20262.entity.Disciplina;
import br.gov.sp.cps.springtopicos20262.repository.DisciplinaRepository;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository repo;

    private final CursoService cursoService;

    private final AlunoService alunoService;

    public DisciplinaServiceImpl(DisciplinaRepository repo, CursoService cursoService, AlunoService alunoService) {
        this.repo = repo;
        this.cursoService = cursoService;
        this.alunoService = alunoService;
    }

    @Override
    @Transactional
    public Disciplina cadastrar(Disciplina disciplina) {
        if(disciplina == null ||
                disciplina.getId() != null ||
                disciplina.getNome() == null || 
                disciplina.getNome().isBlank() ||
                disciplina.getCodigo() == null || 
                disciplina.getCodigo().isBlank() ||
                disciplina.getCurso() == null ||
                disciplina.getCurso().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados da disciplina inválidos");
        }
        disciplina.setCurso(cursoService.buscarPorId(disciplina.getCurso().getId()));
        if(disciplina.getAlunos() != null) {
            disciplina.getAlunos().forEach(aluno -> {
                alunoService.buscarPorId(aluno.getId());
            });
        }
        try {
            disciplina = repo.save(disciplina);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao cadastrar disciplina: " + e.getMessage(), e);
        }
        return disciplina;
    }

    @Override
    public List<Disciplina> listar() {
        return repo.findAll();
    }

    @Override
    public Disciplina buscarPorId(Long id) {
        if(id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O id da disciplina não pode ser nulo");
        }
        return repo.findById(id).
            orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));
    }

    @Override
    public void matricularAluno(Long disciplinaId, Long alunoId) {
        Disciplina disciplina = buscarPorId(disciplinaId);
        if(disciplina.getAlunos() == null) {
            disciplina.setAlunos(new HashSet<Aluno>());
        }
        disciplina.getAlunos().add(alunoService.buscarPorId(alunoId));
        repo.save(disciplina);
    }
    
}
