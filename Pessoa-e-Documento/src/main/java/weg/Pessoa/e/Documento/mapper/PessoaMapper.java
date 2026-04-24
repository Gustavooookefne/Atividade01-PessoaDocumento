package weg.Pessoa.e.Documento.mapper;

import org.springframework.stereotype.Component;
import weg.Pessoa.e.Documento.dto.PessoaDto.PessoaRequestDto;
import weg.Pessoa.e.Documento.dto.PessoaDto.PessoaResponseDto;
import weg.Pessoa.e.Documento.model.Pessoa;

@Component
public class PessoaMapper {

    public Pessoa paraEntidade (PessoaRequestDto requestDto){
        return new Pessoa(
                requestDto.nome(),
                requestDto.documento()
        );
    }

    public PessoaResponseDto paraDto (Pessoa pessoa) {
        return new PessoaResponseDto(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getDocumento()
        );
    }
}
