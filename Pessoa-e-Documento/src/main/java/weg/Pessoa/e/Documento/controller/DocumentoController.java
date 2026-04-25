package weg.Pessoa.e.Documento.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weg.Pessoa.e.Documento.dto.DocumentoDto.DocumentoRequestDto;
import weg.Pessoa.e.Documento.dto.DocumentoDto.DocumentoResponseDto;
import weg.Pessoa.e.Documento.service.DocumentoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/documento")
public class DocumentoController {

    private final DocumentoService service;

    @PostMapping
    public ResponseEntity<DocumentoResponseDto> salvar (@RequestBody DocumentoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salve(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoResponseDto>> listarTodos () {
         List<DocumentoResponseDto> responseDtos = service.listarTodos();

         return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponseDto> listarPorId (@PathVariable Long id) {
        DocumentoResponseDto requestDto = service.listarPorId(id);

        return ResponseEntity.ok().body(requestDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoResponseDto> atualizar (@RequestBody DocumentoRequestDto requestDto , @PathVariable Long id) {
        DocumentoResponseDto responseDto = service.atualizar(requestDto , id);

        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
