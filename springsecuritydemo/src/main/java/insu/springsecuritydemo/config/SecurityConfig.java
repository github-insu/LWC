package insu.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                // 특정 URL에 대한 인가 설정.
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/board").authenticated()
                    .anyRequest().permitAll()
                )
                // 권한이 필요한 요청은 해당 URL로 리다이렉트
                .formLogin(login -> login
                        .defaultSuccessUrl("/home")
                )
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}