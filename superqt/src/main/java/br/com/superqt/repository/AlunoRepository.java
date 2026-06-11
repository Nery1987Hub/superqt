package br.com.superqt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.superqt.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{}