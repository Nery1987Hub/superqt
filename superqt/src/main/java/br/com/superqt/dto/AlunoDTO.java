package br.com.superqt.dto;

import br.com.superqt.model.Perfil;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoDTO(
    @NotBlank String senha,
    @NotNull @Min(0) int idade,
    @NotBlank String nome,
    @Enumerated Perfil perfil,
    @NotBlank String cpfaluno
){}