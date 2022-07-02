package br.com.itau.codingchallenge2022.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Essa é a classe {@link SecurityConfig} componente que receberá
 * as propriedades e credenciais do token via application.properties.
 * @author ArturBarreto
 */
@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    public void setPrefix(String prefix){
        PREFIX = prefix;
    }
    public void setKey(String key){
        KEY = key;
    }
    public void setExpiration(Long expiration){
        EXPIRATION = expiration;
    }
}