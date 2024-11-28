package com.tuempresa.rrhh.infrastructure.persintence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nit;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private int idUser;
    private String firstLevel;
    private String secondLevel;
    private LocalDate entryDate;
    private String turn;
    private String schedule;
    private int idArea;
    private int idDepartment;
    private int idPosition;
    private int idWorkcenter;
    private int restDay;
}
