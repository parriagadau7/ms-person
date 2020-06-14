package cl.parriagada.ms.person.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
//The prePostEnabled property enables Spring Security pre/post annotations
//The securedEnabled property determines if the @Secured annotation should be enabled
//The jsr250Enabled property allows us to use the @RoleAllowed annotation
public class MethodSecurityConfig
        extends GlobalMethodSecurityConfiguration {
}

