package dev.jardim.tarefas.database.repository;

import dev.jardim.tarefas.database.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
