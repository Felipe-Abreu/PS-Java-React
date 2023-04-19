package br.com.banco.Controller;

import br.com.banco.Model.Conta;
import br.com.banco.Service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("conta")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ContaController {

    @Autowired
    private final ContaService contaService;

    @PutMapping(value = "saque/{id:[0-9]+}")
    public ResponseEntity<Conta> sacar(@PathVariable("id") Long idConta, @RequestBody Conta conta){
        BigDecimal valor = conta.getSaldo();
        return contaService.saque(idConta, valor);
    }

    @PutMapping(value = "deposito/{id:[0-9]+}")
    public ResponseEntity<Conta> depositar(@PathVariable("id") Long idConta, @RequestBody Conta conta){
        BigDecimal valor = conta.getSaldo();
        return contaService.deposito(idConta, valor);
    }

}
