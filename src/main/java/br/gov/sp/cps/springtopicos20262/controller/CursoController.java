package br.gov.sp.cps.springtopicos20262.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso) {
        Curso novo = service.cadastrar(curso);
        return ResponseEntity.created(URI.create("/curso/" + novo.getId())).body(novo);
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
