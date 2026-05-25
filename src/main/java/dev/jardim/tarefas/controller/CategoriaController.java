package dev.jardim.tarefas.controller;

import dev.jardim.tarefas.dto.request.CategoriaRequestDto;
import dev.jardim.tarefas.dto.response.CategoriaResponseDto;
import dev.jardim.tarefas.exception.NotFoundException;
import dev.jardim.tarefas.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDto criarCategoria(@Valid @RequestBody CategoriaRequestDto dto) {
        return categoriaService.criarCategoria(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaResponseDto> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaResponseDto buscarId(@PathVariable Long id) throws NotFoundException {
        return categoriaService.buscarId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaResponseDto atualizarCategoria(
            @PathVariable Long id,
            @Valid @RequestBody CategoriaRequestDto dto) throws NotFoundException {
        return categoriaService.atualizarCategoria(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable Long id) throws NotFoundException {
        categoriaService.deletarCategoria(id);
    }
}