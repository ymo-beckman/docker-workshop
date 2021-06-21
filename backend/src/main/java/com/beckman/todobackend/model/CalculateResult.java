package com.beckman.todobackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        schema = "workshop",
        name = "calculate_results",
        indexes = {
                @Index(name = "idx_calc_num", columnList = "n_num_1")
        }
)
public class CalculateResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calcResultSeq")
    @SequenceGenerator(name = "calcResultSeq", allocationSize = 1, sequenceName = "CALC_RESULT_SEQUENCE", schema = "workshop")
    @Column(name = "n_id")
    long id;

    @Column(name = "n_num_1")
    long number;

    @Column(name = "n_result")
    long result;
}
