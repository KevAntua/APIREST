package com.accenture.capability.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,"/**").permitAll()
                .antMatchers("/principalCursos").hasAnyRole("USER")
                .and()
                    .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .antMatchers("/eliminarCurso/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic();


        http.headers().frameOptions().disable();
    }
    
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder encoder = passwordEncoder();
        UserBuilder user = User.builder().passwordEncoder(encoder::encode);
        
        builder.inMemoryAuthentication()
                .withUser(user.username("admin").password("ACCENTURE").roles("ADMIN","USER"))
                .withUser(user.username("accesogeneral").password("ACCENTURE").roles("USER"));
    }

}
