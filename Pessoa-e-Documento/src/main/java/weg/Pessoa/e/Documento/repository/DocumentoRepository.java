package weg.Pessoa.e.Documento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weg.Pessoa.e.Documento.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento , Long> {
}
