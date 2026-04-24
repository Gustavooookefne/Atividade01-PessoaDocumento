package weg.Pessoa.e.Documento.dto.PessoaDto;

import weg.Pessoa.e.Documento.model.Documento;

public record PessoaRequestDto (
        String nome,
        Documento documento
){
}
