package br.gov.sp.cps.springtopicos20262.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.cps.springtopicos20262.entity.Trabalho;
import br.gov.sp.cps.springtopicos20262.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping("/trabalho")
public class TrabalhoController {

    private final TrabalhoService service;

    public TrabalhoController(TrabalhoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trabalho> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Trabalho> cadastrar(@RequestBody Trabalho trabalho) {
        Trabalho trabalhoCadastrado = service.cadastrar(trabalho);
        return ResponseEntity.created(URI.create("/trabalho")).body(trabalhoCadastrado);
    }

    @GetMapping("/buscar")
    public List<Trabalho> buscarPorRaAlunoETitulo(@RequestParam("ra") Long ra, @RequestParam("titulo") String titulo) {
        return service.buscarPorRaAlunoETitulo(ra, titulo);
    }

}
