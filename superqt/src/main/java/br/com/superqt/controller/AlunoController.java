package br.com.superqt.controller;

import java.net.URI;
// import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.superqt.dto.AlunoDTO;
import br.com.superqt.model.Aluno;
import br.com.superqt.service.AlunoService;
// import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController{

    private final AlunoService service;

    public AlunoController(AlunoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody AlunoDTO dto){
        Aluno a = service.criar(dto);
        return ResponseEntity.created(URI.create("/aluno"+ a.getId())).body(a);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> consultar(@PathVariable Long id){
        Aluno aluno = service.buscarPorId(id);

        if(aluno == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(aluno);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        boolean status = service.excluir(id);
        if(!status){
            return ResponseEntity.notFound().build();
           
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    
    // @GetMapping
    // public String teste(){
    //     return "Teste do Servidor";
    // }
}