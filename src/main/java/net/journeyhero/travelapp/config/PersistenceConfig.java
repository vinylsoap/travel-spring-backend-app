package net.journeyhero.travelapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.security.Principal;
import java.util.Optional;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Principal::getName);
    }

}
