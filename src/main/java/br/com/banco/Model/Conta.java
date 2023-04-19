package br.com.banco.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    @NotNull
    private Long idConta;
    @Column(name = "nome_responsavel")
    @NotNull
    private String responsavel;
    @Column(name = "saldo")
    private BigDecimal saldo;

}
