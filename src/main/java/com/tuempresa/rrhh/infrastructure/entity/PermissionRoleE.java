package com.tuempresa.rrhh.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "permission_role")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PermissionRoleE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 255)
    String nameRole;

}
