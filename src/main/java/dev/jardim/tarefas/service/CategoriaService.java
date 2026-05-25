package dev.jardim.tarefas.service;

import dev.jardim.tarefas.database.model.CategoriaEntity;
import dev.jardim.tarefas.database.repository.CategoriaRepository;
import dev.jardim.tarefas.dto.request.CategoriaRequestDto;
import dev.jardim.tarefas.dto.response.CategoriaResponseDto;
import dev.jardim.tarefas.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResponseDto criarCategoria(CategoriaRequestDto dto) {

        CategoriaEntity categoria = CategoriaEntity.builder()
                .nome(dto.getNome())
                .build();

        return toResponse(categoriaRepository.save(categoria));
    }

    public List<CategoriaResponseDto> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CategoriaResponseDto buscarId(Long id) throws NotFoundException {
        return toResponse(categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada")));
    }

    public CategoriaResponseDto atualizarCategoria(Long id, CategoriaRequestDto dto) throws NotFoundException {

        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        categoria.setNome(dto.getNome());

        return toResponse(categoriaRepository.save(categoria));
    }

    public void deletarCategoria(Long id) throws NotFoundException{

        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        categoriaRepository.delete(categoria);
    }

    private CategoriaResponseDto toResponse(CategoriaEntity categoria) {
        return CategoriaResponseDto.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }
}