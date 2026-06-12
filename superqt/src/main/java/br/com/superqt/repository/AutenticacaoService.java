package br.com.superqt.repository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superqt.dto.LoginRequestDTO;
import br.com.superqt.model.Aluno;

@Service
public class AutenticacaoService{
    private final AlunoRepository alunoRepository;

    AutenticacaoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno autenticar(LoginRequestDTO dto){
        Aluno aluno = alunoRepository.findByCpfaluno(dto.cpfaluno())
            .orElseThrow(() -> new RuntimeException("CPF ou senha inválidos"));

        if (!aluno.getSenha().equals(dto.senha())){
            throw new RuntimeException("CPF ou senha inválidos");
        }
        return aluno;
    }
}
