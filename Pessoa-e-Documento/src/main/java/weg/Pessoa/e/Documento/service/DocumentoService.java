package weg.Pessoa.e.Documento.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.Pessoa.e.Documento.dto.DocumentoDto.DocumentoRequestDto;
import weg.Pessoa.e.Documento.dto.DocumentoDto.DocumentoResponseDto;
import weg.Pessoa.e.Documento.mapper.DocumentoMapper;
import weg.Pessoa.e.Documento.model.Documento;
import weg.Pessoa.e.Documento.repository.DocumentoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentoService {

    private final DocumentoRepository repository;
    private final DocumentoMapper mapper;

    public DocumentoResponseDto salve (DocumentoRequestDto requestDto) {

        Documento documento = new Documento();

        return mapper.paraDto(repository.save(documento));
    }

    public List<DocumentoResponseDto> listarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public DocumentoResponseDto listarPorId (Long id) {
        Documento documento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(documento);

    }

    public DocumentoResponseDto atualizar (DocumentoRequestDto requestDto , Long id) {
        Documento documento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        documento.setNumero(requestDto.numero());
        documento.setCpf(requestDto.cpf());

        return mapper.paraDto(documento);

    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }
}
