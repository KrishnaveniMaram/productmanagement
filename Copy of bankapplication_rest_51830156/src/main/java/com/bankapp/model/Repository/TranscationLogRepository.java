package com.bankapp.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.TransactionLog;
@Repository
public interface TranscationLogRepository  extends JpaRepository<TransactionLog, Long>{
	

}
