package br.com.superqt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.superqt.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    Optional<Aluno> findByCpfaluno(String cpfaluno);
}