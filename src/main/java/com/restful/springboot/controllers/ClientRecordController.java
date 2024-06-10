package com.restful.springboot.controllers;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.restful.springboot.dtos.ClientRecordDto;
import com.restful.springboot.models.ClientRecordModel;
import com.restful.springboot.services.ClientRecordService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/compras")
public class ClientRecordController {

    @Autowired
    private ClientRecordService clientRecordService;

    @PostMapping
    public ResponseEntity<ClientRecordModel> createClientRecord(@RequestBody @Valid ClientRecordDto clientRecordDto) {
        ClientRecordModel clientRecord = new ClientRecordModel();
        BeanUtils.copyProperties(clientRecordDto, clientRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRecordService.save(clientRecord));
    }

    @GetMapping
    public ResponseEntity<Page<ClientRecordModel>> getAllClientRecords(Pageable pageable) {
        Page<ClientRecordModel> clientRecordPage = clientRecordService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(clientRecordPage);
    }
}