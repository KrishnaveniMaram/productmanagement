package com.bankapp.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TranscationData;
@Repository
public interface TranscationDataRepository extends JpaRepository<TranscationData, Long> {

	
	 List<TranscationData> findAll();
	 List<TranscationData> findByAccountAccountNumber(long accountNumber);

}
