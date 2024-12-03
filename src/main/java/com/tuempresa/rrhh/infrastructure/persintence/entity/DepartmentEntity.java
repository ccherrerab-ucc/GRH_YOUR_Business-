package com.tuempresa.rrhh.infrastructure.persintence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "department")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 255)
    String name_department;
}
