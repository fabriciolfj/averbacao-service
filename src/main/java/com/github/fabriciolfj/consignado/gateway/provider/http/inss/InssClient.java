package com.github.fabriciolfj.consignado.gateway.provider.http.inss;

import com.github.fabriciolfj.consignado.gateway.provider.http.inss.dto.InssRequest;
import com.github.fabriciolfj.consignado.gateway.provider.http.inss.dto.InssResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inss", url = "${inss.url}")
public interface InssClient {

    @PutMapping("/api/v1/averbacao")
    InssResponse updateReserva(@RequestBody final InssRequest request);
}
