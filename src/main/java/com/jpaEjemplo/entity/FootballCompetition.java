package com.jpaEjemplo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(300)")
    private String name;

    @Column(name = "countity_price")
                               /*  ,length = 10, nullable = false, unique = true, insertable = false, updatable = false) */
                               /*    máxima de caracteres, el parámetro no debe ser nulo, debe ser único, puede ser insertados valores, no puede ser actualizado*/
    private Integer countityPrice;

    @Column(name = "start_date", columnDefinition = "DATE") /*define que tipo de dato es*/
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
