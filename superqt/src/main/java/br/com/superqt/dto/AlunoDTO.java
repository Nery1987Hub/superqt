package br.com.superqt.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoDTO(
    @NotBlank String senha,
    @NotNull @Min(0) int idade,
    @NotBlank String cpfaluno
) {}