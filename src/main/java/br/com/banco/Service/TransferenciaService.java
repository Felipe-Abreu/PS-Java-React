package br.com.banco.Service;

import br.com.banco.Model.Conta;
import br.com.banco.Model.Transferencia;
import br.com.banco.Repository.TransferenciaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> extrato(LocalDate dataInicio, LocalDate dataFim, String nomeOperador) {
        if (dataInicio == null && dataFim == null && nomeOperador == null) {
            return transferenciaRepository.findAll();
        } else if (dataInicio != null && dataFim != null && nomeOperador != null) {
            return transferenciaRepository.findByDataTransferenciaBetweenAndNomeOperador(dataInicio, dataFim, nomeOperador);
        } else if (dataInicio != null && dataFim != null) {
            return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
        } else if (nomeOperador != null) {
            return transferenciaRepository.findByNomeOperador(nomeOperador);
        } else {
            throw new IllegalArgumentException("Filtros inválidos");
        }
    }

    public void novaTransferencia(Conta conta, BigDecimal valor, String tipo) {

        Transferencia nova = new Transferencia();
        nova.setDataTransferencia(LocalDate.now());
        nova.setTipo(tipo);
        nova.setValor(valor);
        nova.setContaId(conta);
        transferenciaRepository.save(nova);
    }

}
