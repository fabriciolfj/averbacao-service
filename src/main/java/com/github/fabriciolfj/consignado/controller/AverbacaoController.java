package com.github.fabriciolfj.consignado.controller;

import com.github.fabriciolfj.consignado.business.usecase.AverbacaoCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/averbacao")
@RequiredArgsConstructor
@Api(value = "Operações relacionadas a averbação do consignado", tags = {"Averbação"})
public class AverbacaoController {

    private final AverbacaoCase averbacaoCase;

    @PutMapping
    @ApiOperation(
            value = "Averbar consignados pendentes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 204, message = "No acontent"),
                    @ApiResponse(code = 404, message = "Request invalid"),
                    @ApiResponse(code = 500, message = "Server error")
            })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void averbacaoExecute() {
        averbacaoCase.execute();
    }
}
