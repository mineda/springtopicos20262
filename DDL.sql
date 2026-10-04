create table aln_aluno (
    aln_id bigint generated always as identity,
    aln_ra bigint not null,
    aln_nome varchar(100) not null,
    aln_data_nascimento date,
    primary key (aln_id),
    unique (aln_ra)
);

create table cur_curso (
    cur_id bigint generated always as identity,
    cur_sigla varchar(10) not null,
    cur_nome varchar(100) not null,
    primary key (cur_id),
    constraint cur_sigla_uk unique (cur_sigla)
);

create table dis_disciplina (
    dis_id bigint generated always as identity,
    dis_codigo varchar(10) not null,
    dis_nome varchar(100) not null,
    dis_carga_horaria int,
    dis_cur_id bigint not null,
    primary key(dis_id),
    constraint dis_codigo_uk unique (dis_codigo),
    constraint dis_cur_fk
    foreign key (dis_cur_id) references cur_curso(cur_id)
);

create table mat_matricula (
    mat_aln_id bigint,
    mat_dis_id bigint,
    primary key(mat_aln_id, mat_dis_id),
    constraint mat_aln_fk
    foreign key (mat_aln_id) references aln_aluno(aln_id),
    constraint mat_dis_fk
    foreign key (mat_dis_id) references dis_disciplina(dis_id)
);

insert into aln_aluno(aln_ra, aln_nome, aln_data_nascimento)
    values (1, 'John Doe', '08-10-2001'),
        (2, 'Jane Smith', '10-21-2002');
insert into cur_curso(cur_sigla, cur_nome)
    values ('BD', 'Banco de Dados'),
        ('ADS', 'Análise e Desenvolvimento de Sistemas');
insert into dis_disciplina(dis_codigo, dis_nome, dis_carga_horaria, dis_cur_id)
    values ('IMB003', 'Arquitetura e Modelagem de Banco de Dados', 80, 1),
        ('IES001', 'Engenharia de Software I', null, 1);
insert into mat_matricula(mat_aln_id, mat_dis_id)
    values (1, 1),
        (1, 2),
        (2, 1);

create user spring with password 'pass123';

-- Tabela do exemplo
create table tra_trabalho (
  tra_id bigint generated always as identity,
  tra_titulo varchar(100) not null unique,
  tra_data_hora_entrega timestamp not null,
  tra_descricao varchar(200), 
  tra_aluno bigint not null,
  tra_nota int,
  tra_justificativa varchar(100),
primary key(tra_id),
  constraint tra_aln_fk foreign key(tra_aluno) references aln_aluno(aln_id)
);

insert into tra_trabalho (tra_titulo, tra_data_hora_entrega, tra_aluno, tra_nota, tra_justificativa)
  values ('Teste 1', current_timestamp, 1, 6, 'Bom, mas falta conteúdo'),
    ('Teste 2', current_timestamp, 2, null, 'Incompleto');

grant update, delete, insert, select on all tables in schema public to spring;
