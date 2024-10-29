package com.tuempresa.rrhh.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "company")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nameCompany;

}
