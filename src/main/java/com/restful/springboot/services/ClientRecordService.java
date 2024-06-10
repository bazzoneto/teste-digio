package com.restful.springboot.services;

import jakarta.persistence.Id;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.restful.springboot.models.ClientRecordModel;
import com.restful.springboot.repositories.ClientRecordRepository;

@Service
public class ClientRecordService {

    @Autowired
    private ClientRecordRepository clientRecordRepository;

    @Transactional
    public ClientRecordModel save(ClientRecordModel clientRecordModel) {
        return clientRecordRepository.save(clientRecordModel);
    }

    public Page<ClientRecordModel> findAll(Pageable pageable) {
        return clientRecordRepository.findAll(pageable);
    }

    @Transactional
    public void delete(ClientRecordModel clientRecordModel) {
        clientRecordRepository.delete(clientRecordModel);
    }

}
