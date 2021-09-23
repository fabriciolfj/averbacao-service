package com.github.fabriciolfj.consignado.controller;

import com.github.fabriciolfj.consignado.business.usecase.ConsignadoCase;
import com.github.fabriciolfj.consignado.controller.dto.request.ConsignadoRequest;
import com.github.fabriciolfj.consignado.controller.dto.response.ConsignadoResponse;
import com.github.fabriciolfj.consignado.controller.mappers.ConsignadoDTOMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/consignado")
@RequiredArgsConstructor
@Api(value = "Operações relacionadas a rotina de consignado", tags = {"Consignado"})
public class ConsignadoController {

    private final ConsignadoCase consignadoCase;

    @ApiOperation(
            value = "Criando consignado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 204, message = "Content created"),
                    @ApiResponse(code = 404, message = "Request invalid"),
                    @ApiResponse(code = 500, message = "Server error"),
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody final ConsignadoRequest request) {
        consignadoCase.execute(ConsignadoDTOMapper.toDomain(request));
    }

    @ApiOperation(
            value = "Buscar contrato consignado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Request valid"),
                    @ApiResponse(code = 404, message = "Contract not found"),
                    @ApiResponse(code = 500, message = "Server error")
            }
    )
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ConsignadoResponse find(@PathVariable("code") final String code) {
        return ConsignadoDTOMapper.toResponse(consignadoCase.execute(code));
    }
}
