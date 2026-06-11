package br.com.superqt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.superqt.dto.AlunoDTO;
import br.com.superqt.model.Aluno;
import br.com.superqt.repository.AlunoRepository;

// senha  cpfaluno  idade

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public Aluno criar(AlunoDTO dto){
        System.out.println(dto.cpfaluno());
        Aluno aluno = new Aluno(dto.senha(), dto.cpfaluno(), dto.idade());
        return repository.save(aluno);
    }

    public Aluno buscarPorId(Long id){
        return  repository.findById(id).orElse(null);
    }

    public boolean excluir(Long id){
        boolean res = repository.existsById(id);
        if(res){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public List<Aluno> listarTodos(){
        return repository.findAll();
    }
}