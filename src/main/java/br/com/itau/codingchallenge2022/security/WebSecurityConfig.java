package br.com.itau.codingchallenge2022.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable()
                .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()

                .antMatchers(HttpMethod.GET,"/").permitAll()
                .antMatchers(HttpMethod.GET,"/register").permitAll()
                .antMatchers(HttpMethod.GET,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/register").permitAll()

                .antMatchers(HttpMethod.GET,"/movie/**").hasAnyRole("LEITOR")

                .antMatchers(HttpMethod.GET,"/commentary").hasAnyRole("LEITOR")
                .antMatchers(HttpMethod.GET,"/commentary/movie/**").hasAnyRole("LEITOR")
                .antMatchers(HttpMethod.GET,"/commentary/user/**").hasAnyRole("LEITOR")

                .antMatchers(HttpMethod.GET,"/rating").hasAnyRole("LEITOR")
                .antMatchers(HttpMethod.GET,"/rating/movie/**").hasAnyRole("LEITOR")
                .antMatchers(HttpMethod.GET,"/rating/user/**").hasAnyRole("LEITOR")
                .antMatchers(HttpMethod.POST,"/rating").hasAnyRole("LEITOR")

                .antMatchers(HttpMethod.POST,"/commentary").hasAnyRole("BASICO")
                .antMatchers(HttpMethod.POST,"/commentary/responseto/**").hasAnyRole("BASICO")

                .antMatchers(HttpMethod.POST,"/commentary/quotingcommentary/**").hasAnyRole("AVANCADO")
                .antMatchers(HttpMethod.POST,"/commentary/likedislike/**").hasAnyRole("AVANCADO")

                .antMatchers(HttpMethod.GET,"/admin/users").hasAnyRole("MODERADOR")
                .antMatchers(HttpMethod.POST,"/admin/makeusermoderator/**").hasAnyRole("MODERADOR")
                .antMatchers(HttpMethod.DELETE,"/commentary/**").hasAnyRole("MODERADOR")
                .antMatchers(HttpMethod.POST,"/commentary/repeated/**").hasAnyRole("MODERADOR")
                .antMatchers(HttpMethod.GET,"/commentary/likedislike").hasAnyRole("MODERADOR")

                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}