create table aln_aluno (
    aln_id bigint generated always as identity,
    aln_ra bigint not null,
    aln_nome varchar(100) not null,
    aln_data_nascimento date,
    primary key (aln_id),
    unique (aln_ra)
);

create user spring with password 'pass123';

grant update, delete, insert, select on all tables in schema public to spring;