package br.gov.sp.cps.springtopicos20262.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.cps.springtopicos20262.entity.Curso;
import br.gov.sp.cps.springtopicos20262.service.CursoService;

@RestController
@RequestMapping("/curso")
@CrossOrigin
public class CursoController {
    
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {
        return service.cadastrar(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }
}
