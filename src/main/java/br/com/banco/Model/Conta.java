package br.com.banco.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conta")
    @NotNull
    private Long idConta;
    @Column(name = "nome_responsavel")
    @NotNull
    private String responsavel;

}
