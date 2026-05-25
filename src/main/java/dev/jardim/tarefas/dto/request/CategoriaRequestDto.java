package dev.jardim.tarefas.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaRequestDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;
}