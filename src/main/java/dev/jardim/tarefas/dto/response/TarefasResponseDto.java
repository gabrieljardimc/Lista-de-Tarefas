package dev.jardim.tarefas.dto.response;

import dev.jardim.tarefas.enums.TarefaPrioridade;
import dev.jardim.tarefas.enums.TarefaStatus;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TarefasResponseDto {

    private Long id;

    private String titulo;

    private String descricao;

    private TarefaStatus status;

    private TarefaPrioridade prioridade;

    private LocalDate dataCriacao;

    private LocalDate prazo;

    private boolean concluida;

    private Long categoriaId;
}