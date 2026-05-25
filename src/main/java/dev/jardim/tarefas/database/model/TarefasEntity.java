package dev.jardim.tarefas.database.model;

import dev.jardim.tarefas.enums.TarefaPrioridade;
import dev.jardim.tarefas.enums.TarefaStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TarefasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TarefaStatus status;

    @Enumerated(EnumType.STRING)
    private TarefaPrioridade prioridade;

    private LocalDate dataCriacao;
    private LocalDate prazo;
    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

}
