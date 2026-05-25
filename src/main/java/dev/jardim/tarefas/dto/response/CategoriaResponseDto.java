package dev.jardim.tarefas.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaResponseDto {

    private Long id;

    private String nome;
}