package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.core.domain.request.Request;
import com.tuempresa.rrhh.infrastructure.persintence.entity.EmployeeE;
import com.tuempresa.rrhh.infrastructure.persintence.entity.RequestEntity;

public class RequestMapper {

    // Mapeo de Request a RequestEntity
    public static RequestEntity toEntity(Request request) {
        RequestEntity requestEntity = new RequestEntity();

        // Mapeo de campos simples
        requestEntity.setId(request.getId());
        requestEntity.setDateRequest(request.getDateRequest());
        requestEntity.setComment(request.getComment());
        requestEntity.setDateStart(request.getDateStart());
        requestEntity.setDateFinal(request.getDateFinal());
        requestEntity.setStatusCode(request.getStatusCode());
        requestEntity.setIdTipeRequest(request.getIdTipeRequest());

        // Mapeo de la relación ManyToOne (EmployeeE)
        if (request.getEmployees() != null) {
            EmployeeE employee = new EmployeeE();
            employee.setId(request.getEmployees());  // Asignar el ID del empleado al objeto EmployeeE
            requestEntity.setEmployee(employee);
        }

        return requestEntity;
    }

    // Mapeo de RequestEntity a Request
    public static Request toDomain(RequestEntity requestEntity) {
        Request request = new Request();

        // Mapeo de campos simples
        request.setId(requestEntity.getId());
        request.setDateRequest(requestEntity.getDateRequest());
        request.setComment(requestEntity.getComment());
        request.setDateStart(requestEntity.getDateStart());
        request.setDateFinal(requestEntity.getDateFinal());
        request.setStatusCode(requestEntity.getStatusCode());
        request.setIdTipeRequest(requestEntity.getIdTipeRequest());
        request.setEmployees(requestEntity.getEmployee().getId());  // Obtener el ID del empleado

        /* Mapeo de la relación ManyToOne (EmployeeE)
        if (requestEntity.getEmployee() != null && requestEntity.getEmployee().getId() != null) {
            request.setEmployees(requestEntity.getEmployee().getId());  // Obtener el ID del empleado
        }
         */

        return request;
    }
}

