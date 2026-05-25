package dev.jardim.tarefas.dto.request;

import dev.jardim.tarefas.enums.TarefaPrioridade;
import dev.jardim.tarefas.enums.TarefaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TarefasRequestDto {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    private TarefaStatus status;

    @NotNull
    private TarefaPrioridade prioridade;

    @NotNull
    private LocalDate prazo;

    @NotNull
    private Long categoriaId;

    private boolean concluida;
}