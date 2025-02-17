package br.com.banco.Controller;

import br.com.banco.Model.Conta;
import br.com.banco.Model.Transferencia;
import br.com.banco.Service.TransferenciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("transferencia")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TransferenciaController {

    @Autowired
    private final TransferenciaService transferenciaService;

    @GetMapping("extrato")
    public List<Transferencia> extratoContabil(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDate dataFim,
            @RequestParam(required = false) String nomeOperador
    ) {
        return transferenciaService.extrato(dataInicio, dataFim, nomeOperador);
    }

}
