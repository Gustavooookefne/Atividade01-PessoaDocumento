package weg.Pessoa.e.Documento.dto.PessoaDto;

import weg.Pessoa.e.Documento.model.Documento;

public record PessoaResponseDto (
        Long id,
        String nome,
        Documento documento
){
}
