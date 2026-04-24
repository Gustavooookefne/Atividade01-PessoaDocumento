package weg.Pessoa.e.Documento.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weg.Pessoa.e.Documento.dto.PessoaDto.PessoaRequestDto;
import weg.Pessoa.e.Documento.dto.PessoaDto.PessoaResponseDto;
import weg.Pessoa.e.Documento.service.PessoaService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    @PutMapping
    public ResponseEntity<PessoaResponseDto> salvar (@RequestBody PessoaRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDto>> listarTodos () {
        List<PessoaResponseDto> responseDtos = service.listarTodos();

        return ResponseEntity.ok().body(responseDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> listarPorId (@PathVariable Long id) {
        PessoaResponseDto responseDto = service.listarPorId(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> atualizar (@RequestBody PessoaResponseDto responseDto ,@PathVariable Long id) {
        PessoaResponseDto responseDto1 = service.atualizar(responseDto, id);

        return ResponseEntity.ok().body(responseDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
