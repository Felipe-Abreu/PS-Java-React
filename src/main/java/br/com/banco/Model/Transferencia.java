package br.com.banco.Model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_transferencia")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private LocalDate dataTransferencia;
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @NotNull
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "nome_operador_transacao")
    private  String nomeOperador;

    @NotNull
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "conta_id")
    private Conta contaId;

}
