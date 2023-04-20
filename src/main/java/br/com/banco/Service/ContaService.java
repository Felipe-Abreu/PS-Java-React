package br.com.banco.Service;

import br.com.banco.Enum.TipoTransação;
import br.com.banco.Model.Conta;
import br.com.banco.Repository.ContaRepository;
import br.com.banco.Repository.TransferenciaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class ContaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private ContaRepository contaRepository;

    public ResponseEntity<Conta> saque(Long idConta, BigDecimal valor) {
        Conta conta = contaRepository.findById(idConta).get();
        BigDecimal saldo = conta.getSaldo();
        saldo = saldo.subtract(valor);
        conta.setSaldo(saldo);

        transferenciaService.novaTransferencia(conta, valor.negate(), TipoTransação.SAQUE);

        contaRepository.save(conta);
        return ResponseEntity.ok(conta);
    }

    public ResponseEntity<Conta> deposito(Long idConta, BigDecimal valor) {
        Conta conta = contaRepository.findById(idConta).get();
        BigDecimal saldo = conta.getSaldo();
        saldo = saldo.add(valor);
        conta.setSaldo(saldo);

        transferenciaService.novaTransferencia(conta, valor, TipoTransação.DEPOSITO);

        contaRepository.save(conta);
        return ResponseEntity.ok(conta);
    }

}
