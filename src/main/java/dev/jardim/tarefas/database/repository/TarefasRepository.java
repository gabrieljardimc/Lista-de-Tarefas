package dev.jardim.tarefas.database.repository;

import dev.jardim.tarefas.database.model.TarefasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasEntity, Long> {
}
