package net.journeyhero.travelapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {@Server(url = "/")})
@SecurityScheme(name = "Auth0", type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(authorizationCode = @OAuthFlow(tokenUrl = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}oauth/token", authorizationUrl = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}authorize")))
public class SwaggerConfig {

}
