package com.tuempresa.rrhh.infrastructure.persintence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")  // Define el nombre de la tabla en la base de datos
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Si el campo `id` es autoincremental
    @Column(name = "id")  // Especifica el nombre de la columna en la tabla
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_employees", referencedColumnName = "id")  // Relación con la tabla de empleados
    private EmployeeE employee;

    @Column(name = "date_request")
    private Date dateRequest;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_final")
    private Date dateFinal;

    @Column(name = "id_tipe_request")
    private Integer idTipeRequest;

    @Column(name = "status_code")
    private Integer statusCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeE getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeE employee) {
        this.employee = employee;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Integer getIdTipeRequest() {
        return idTipeRequest;
    }

    public void setIdTipeRequest(Integer idTipeRequest) {
        this.idTipeRequest = idTipeRequest;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
