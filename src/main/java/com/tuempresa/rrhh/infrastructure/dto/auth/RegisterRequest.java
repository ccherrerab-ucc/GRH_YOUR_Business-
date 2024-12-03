package com.tuempresa.rrhh.infrastructure.dto.auth;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import com.tuempresa.rrhh.infrastructure.persintence.entity.DepartmentEntity;
import com.tuempresa.rrhh.infrastructure.persintence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String email;
    String password;
    Integer status;
    Integer role;
    Integer company;

    String nit;
    String name;
    String firstSurname;
    String secondSurname;
    Integer idUser;
    String firstLevel;
    String secondLevel;
    LocalDate entryDate;
    String turn;
    String schedule;
    Integer idArea;
    Integer idDepartment;
    Integer idPosition;
    Integer idWorkcenter;
    Integer restDay;
}
