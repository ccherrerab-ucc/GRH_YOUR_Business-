package com.tuempresa.rrhh.infrastructure.persintence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tuempresa.rrhh.core.domain.User;
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
    @OneToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserEntity idUser;
    private String firstLevel;
    private String secondLevel;
    private LocalDate entryDate;
    private String turn;
    private String schedule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_area", nullable = false)
    private AreaEntity idArea;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departament", nullable = false)
    private DepartmentEntity idDepartment;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_position", nullable = false)
    private PositionEntity idPosition;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_workcenter", nullable = false)
    private WorkcenterEntity idWorkcenter;
    private int restDay;
}
