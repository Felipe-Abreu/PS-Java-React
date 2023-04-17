package br.com.banco.Repository;

import br.com.banco.Model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findByDataTransferenciaBetween(LocalDate dataInicio, LocalDate dataFim);

    List<Transferencia> findByNomeOperador(String nomeOperador);

    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperador(LocalDate dataInicio, LocalDate dataFim, String nomeOperador);

}
