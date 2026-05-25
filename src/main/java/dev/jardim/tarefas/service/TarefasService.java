package dev.jardim.tarefas.service;

import dev.jardim.tarefas.database.model.CategoriaEntity;
import dev.jardim.tarefas.database.model.TarefasEntity;
import dev.jardim.tarefas.database.repository.CategoriaRepository;
import dev.jardim.tarefas.database.repository.TarefasRepository;
import dev.jardim.tarefas.dto.request.TarefasRequestDto;
import dev.jardim.tarefas.dto.response.TarefasResponseDto;
import dev.jardim.tarefas.exception.BadRequestException;
import dev.jardim.tarefas.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final CategoriaRepository categoriaRepository;

    public TarefasResponseDto criarTarefa(TarefasRequestDto dto) throws NotFoundException {

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        TarefasEntity tarefa = TarefasEntity.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .prioridade(dto.getPrioridade())
                .prazo(dto.getPrazo())
                .concluida(dto.isConcluida())
                .categoria(categoria)
                .dataCriacao(LocalDate.now())
                .build();

        return toResponse(tarefasRepository.save(tarefa));
    }

    public List<TarefasResponseDto> listarTarefas() {
        return tarefasRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TarefasResponseDto buscarId(Long id) throws NotFoundException {
        return toResponse(tarefasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarefa não encontrada")));
    }

    public TarefasResponseDto atualizarTarefa(Long id, TarefasRequestDto dto) throws NotFoundException {

        TarefasEntity tarefa = tarefasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarefa não encontrada"));

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setConcluida(dto.isConcluida());
        tarefa.setCategoria(categoria);

        return toResponse(tarefasRepository.save(tarefa));
    }

    public void deletarTarefa(Long id) throws NotFoundException {

        TarefasEntity tarefa = tarefasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarefa não encontrada"));

        tarefasRepository.delete(tarefa);
    }

    private TarefasResponseDto toResponse(TarefasEntity tarefa) {
        return TarefasResponseDto.builder()
                .id(tarefa.getId())
                .titulo(tarefa.getTitulo())
                .descricao(tarefa.getDescricao())
                .status(tarefa.getStatus())
                .prioridade(tarefa.getPrioridade())
                .dataCriacao(tarefa.getDataCriacao())
                .prazo(tarefa.getPrazo())
                .concluida(tarefa.isConcluida())
                .categoriaId(tarefa.getCategoria().getId())
                .build();
    }
}