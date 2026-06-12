package br.com.superqt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="aluno")
public class Aluno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private String senha;

    @NotNull
    @Min(0)
    private int idade;
    
    @NotBlank
    private String cpfaluno;

    public Aluno (){}

    public Aluno(String senha,  String cpfaluno, int idade){
        this.senha = senha;
        this.cpfaluno = cpfaluno;
        this.idade = idade;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getCPFaluno(){
        return cpfaluno;
    }
    public void setCPFaluno(String cpfaluno){
        this.cpfaluno = cpfaluno;
    }
}