package dev.jardim.tarefas.controller;

import dev.jardim.tarefas.dto.request.TarefasRequestDto;
import dev.jardim.tarefas.dto.response.TarefasResponseDto;
import dev.jardim.tarefas.exception.NotFoundException;
import dev.jardim.tarefas.service.TarefasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefasResponseDto criarTarefa(@Valid @RequestBody TarefasRequestDto dto) throws NotFoundException{
        return tarefasService.criarTarefa(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TarefasResponseDto> listarTarefas() {
        return tarefasService.listarTarefas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefasResponseDto buscarId(@PathVariable Long id) throws NotFoundException {
        return tarefasService.buscarId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefasResponseDto atualizarTarefa(@PathVariable Long id,
                                              @Valid @RequestBody TarefasRequestDto dto) throws NotFoundException {
        return tarefasService.atualizarTarefa(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTarefa(@PathVariable Long id) throws NotFoundException {
        tarefasService.deletarTarefa(id);
    }
}