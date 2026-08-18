package br.gov.sp.cps.springtopicos20262.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dis_disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dis_id")
    private Long id;

    @Column(name = "dis_codigo")
    private String codigo;

    @Column(name = "dis_nome")
    private String nome;

    @Column(name = "dis_carga_horaria")
    private Integer cargaHoraria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dis_cur_id")
    private Curso curso;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "mat_matricula",
        joinColumns = @JoinColumn(name = "mat_dis_id"),
        inverseJoinColumns = @JoinColumn(name = "mat_aln_id")
    )
    private Set<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}
