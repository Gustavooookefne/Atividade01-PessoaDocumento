package weg.Pessoa.e.Documento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome_Pessoa", nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id")
    Documento documento;

    public Pessoa(String nome, Documento documento) {
        this.nome = nome;
        this.documento = documento;
    }
}
