package weg.Pessoa.e.Documento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weg.Pessoa.e.Documento.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa , Long> {
}
