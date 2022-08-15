package com.example.boletoprojeto.controller;


import com.example.boletoprojeto.dto.TituloDto;
import com.example.boletoprojeto.model.TituloModel;
import com.example.boletoprojeto.services.TituloService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/titulo")

public class TituloControler {

    final TituloService tituloService;

    public TituloControler(TituloService tituloService) {
        this.tituloService = tituloService;
        //ponto de injeção da service através do construtor
    }

    @PostMapping
    public ResponseEntity<Object> savetitulo(@RequestBody @Valid TituloDto tituloDto) {
       var tituloModel = new TituloModel(); //uso do var é possivel devido a atualização do java
        BeanUtils.copyProperties(tituloDto, tituloModel);//método "copyProperties" conversao de DTO pra model
        tituloModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(tituloService.save(tituloModel));
    }

}

// Nesta classe é feita toda a implementação para tratamento de registros de boletos recebidos
//    @PostMapping("titulo/register")Trata callback de registro de boleto, recebido pelo Core
//    @PutMapping("titulo/update") Trata callback de update de boleto, recebido pelo Core
//    @PutMapping("titulo/checkout")Trata callbacks de baixa efetiva de boleto recebido pelo Core
//    @PutMapping("payer/register")Trata callback de registro de beneficiario, recebido pelo Core


