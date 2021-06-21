package com.beckman.todobackend.repository;

import com.beckman.todobackend.model.CalculateResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CalculateResultRepository extends JpaRepository<CalculateResult, Long> {
    @Query(value = "select * from calculate_results where n_num_1=?1", nativeQuery = true)
    CalculateResult findCalculateResultByNumber(Long number);
}
