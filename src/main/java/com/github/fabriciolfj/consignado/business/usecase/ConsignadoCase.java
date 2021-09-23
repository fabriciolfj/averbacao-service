package com.github.fabriciolfj.consignado.business.usecase;

import com.github.fabriciolfj.consignado.business.FindConsignado;
import com.github.fabriciolfj.consignado.business.SaveConsignado;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.domain.exceptions.SaveConsignadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsignadoCase {

    private final SaveConsignado saveConsignado;
    private final FindConsignado findConsignado;

    public void execute(final Consignado consignado) {
        try {
            saveConsignado.process(consignado);
        } catch (Exception e) {
            throw new SaveConsignadoException("Fail save order. Details: " + e.getMessage());
        }
    }

    public Consignado execute(final String code) {
        return findConsignado.find(code);
    }
}
