package com.github.fabriciolfj.consignado.gateway.provider;

import com.github.fabriciolfj.consignado.business.FindConsignado;
import com.github.fabriciolfj.consignado.business.ListConsignado;
import com.github.fabriciolfj.consignado.business.SaveConsignado;
import com.github.fabriciolfj.consignado.business.UpdateAverbacaoConsignado;
import com.github.fabriciolfj.consignado.domain.Averbacao;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.domain.Status;
import com.github.fabriciolfj.consignado.domain.exceptions.ConsignadoNotFoundException;
import com.github.fabriciolfj.consignado.domain.exceptions.UpdateConsignadoException;
import com.github.fabriciolfj.consignado.gateway.repositories.ConsignadoRepository;
import com.github.fabriciolfj.consignado.gateway.repositories.mapper.ConsignadoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class ConsignadoProvider implements SaveConsignado, FindConsignado, ListConsignado, UpdateAverbacaoConsignado {

    private final ConsignadoRepository consignadoRepository;

    @Override
    public void process(final Consignado consignado) {
        final var entity = ConsignadoMapper.toEntity(consignado);

        consignadoRepository.save(entity);
        log.info("Save order consignado: {}", consignado.getCode());
    }

    @Override
    public Consignado find(final String code) {
        return consignadoRepository.findByCode(code)
                .map(ConsignadoMapper::toDomain)
                .orElseThrow(() -> new ConsignadoNotFoundException("Consignado not found: " + code));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Consignado> findLastPending() {
        return consignadoRepository.findTop5ByStatusByOrderByDueDateAsc(Status.PENDING.getCode())
                .stream()
                .map(entity -> {
                    entity.setStatus(Status.PROCESSING.getCode());
                    return ConsignadoMapper.toDomain(entity);
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void execute(final List<Averbacao> averbacoes) {
        try {
            averbacoes.stream().forEach(av -> consignadoRepository.updateStatus(av.getStatus().getCode(), av.getDescribeError(), av.getCode()));
        } catch (Exception e) {
            throw new UpdateConsignadoException("Fail update consignado. Details: " + e.getMessage());
        }
    }
}
