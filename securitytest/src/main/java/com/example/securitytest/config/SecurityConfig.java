package com.example.securitytest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security.authorizeRequests().antMatchers("/").permitAll();
        security.authorizeRequests().antMatchers("/main").authenticated();
        security.authorizeRequests().antMatchers("/member/**").authenticated();
        security.authorizeRequests().antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN");
        security.authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN");

        security.csrf().disable();

        // 로그인 페이지 성공 시 반환 페이지
        security.formLogin().loginPage("/login").defaultSuccessUrl("/main",true);
        security.formLogin().loginProcessingUrl("/loginAction").defaultSuccessUrl("/main",true);
        security.exceptionHandling().accessDeniedPage("/accessDenied");
        security.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        security.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
