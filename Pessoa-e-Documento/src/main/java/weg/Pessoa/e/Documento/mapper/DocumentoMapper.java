package weg.Pessoa.e.Documento.mapper;

import org.springframework.stereotype.Component;
import weg.Pessoa.e.Documento.dto.DocumentoDto.DocumentoRequestDto;
import weg.Pessoa.e.Documento.dto.DocumentoDto.DocumentoResponseDto;
import weg.Pessoa.e.Documento.model.Documento;

@Component
public class DocumentoMapper {

    public Documento paraEntidade (DocumentoRequestDto requestDto) {
        return new Documento(
                requestDto.numero(),
                requestDto.cpf()
        );
    }


}
