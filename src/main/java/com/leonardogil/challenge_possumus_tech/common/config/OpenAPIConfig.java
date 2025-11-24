package com.leonardogil.challenge_possumus_tech.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "POSSUMUS CHALLENGE",
                contact = @Contact(
                        name = "Leonardo Gil", email = "leonardo_gil02@hotmail.com"
                )
        ),
        servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Render",
                        url = "https://challenge-possumus.onrender.com"
                )
        }
)
public class OpenAPIConfig {
}
