package site.tellmetodo.todoapp.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 함.
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    /**
     * @brief Spring Security 설정
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated())
                //.formLogin(AbstractHttpConfigurer::disable);
                        .formLogin(f -> {
                                f.loginPage("/login")
                                .loginProcessingUrl("/authenticate")
                                .defaultSuccessUrl("/", true);
    //                            .usernameParameter("username")
    //                            .passwordParameter("password");
                        });

        http.authenticationProvider(authenticationProvider);

        return http.build();
    }

    /**
     * @brief Spring Security filter 를 거치지 않는 경로 설정
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/svg/**", "/images/**", "/login");
    }

}
