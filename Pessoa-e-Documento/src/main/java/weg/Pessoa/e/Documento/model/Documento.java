package weg.Pessoa.e.Documento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Numero_Documento", nullable = false)
    private int numero;

    private String cpf;

    public Documento(int numero, String cpf) {
    }
}
