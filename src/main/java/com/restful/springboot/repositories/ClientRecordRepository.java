package com.restful.springboot.repositories;


import com.restful.springboot.models.ClientRecordModel;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRecordRepository extends JpaRepository<ClientRecordModel, UUID> {
}
