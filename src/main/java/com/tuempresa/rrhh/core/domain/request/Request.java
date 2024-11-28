package com.tuempresa.rrhh.core.domain.request;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Request {
    private Integer id;
    private Date dateRequest;
    private String comment;
    private Date dateStart;
    private Date dateFinal;
    private Integer employees;
    private Integer statusCode;
    private Integer idTipeRequest;

}
