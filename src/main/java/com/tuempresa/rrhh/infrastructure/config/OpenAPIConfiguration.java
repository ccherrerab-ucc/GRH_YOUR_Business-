package com.tuempresa.rrhh.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8081");
        server.setDescription("Construcción de software");

        Contact myContact = new Contact();
        myContact.setName("CristianHerrera");
        myContact.setEmail("ccherrera913@ucatolica.edu.co");

        Info information = new Info()
                .title("Example Management System API")
                .version("1.0")
                .description("This API exposes endpoints to show example")
                .contact(myContact);

        return new OpenAPI().servers(List.of(server));
    }
}

