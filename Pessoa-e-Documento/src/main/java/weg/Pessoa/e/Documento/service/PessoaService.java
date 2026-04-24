package weg.Pessoa.e.Documento.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.Pessoa.e.Documento.dto.PessoaDto.PessoaRequestDto;
import weg.Pessoa.e.Documento.dto.PessoaDto.PessoaResponseDto;
import weg.Pessoa.e.Documento.mapper.PessoaMapper;
import weg.Pessoa.e.Documento.model.Pessoa;
import weg.Pessoa.e.Documento.repository.PessoaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    public PessoaResponseDto salvar (PessoaRequestDto requestDto) {

        Pessoa pessoa = new Pessoa();

        return mapper.paraDto(repository.save(pessoa));
    }

    public List<PessoaResponseDto> listarTodos () {

        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public PessoaResponseDto listarPorId (Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(pessoa);
    }

    public PessoaResponseDto atualizar (PessoaResponseDto pessoaResponseDto , Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoaResponseDto.nome());
        pessoa.setDocumento(pessoaResponseDto.documento());

        return mapper.paraDto(pessoa);
    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }
}
