package br.com.superqt.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.superqt.dto.LoginRequestDTO;
import br.com.superqt.model.Aluno;
import br.com.superqt.repository.AutenticacaoService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController{
    private final AutenticacaoService autenticacaoService;

    AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto){
        try{
            Aluno alunoAutenticado = autenticacaoService.autenticar(dto);

            return ResponseEntity.ok(alunoAutenticado);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
