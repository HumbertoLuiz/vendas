package io.github.humbertoluiz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.github.humbertoluiz.security.jwt.JWTFilter;

//@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private static final String[] SWAGGER_WHITELIST = { 
			"/v2/api-docs/**", 
			"/swagger-resources/**",
			"/swagger-resources/**", 
			"/configuration/ui/**", 
			"/configuration/security/**", 
			"/swagger-ui.html/**",
			"/swagger-ui/**", 
			"/webjars/**" 
	};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable().authorizeRequests()
    		.antMatchers(SWAGGER_WHITELIST).permitAll()
			.antMatchers(HttpMethod.POST, "/api/v1/users/**").permitAll()
            .antMatchers("/users/**", "/settings/**").hasAuthority("Admin")
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/api/v1/clientes/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/api/v1/pedidos/**")
			.hasAnyRole("USER", "ADMIN")
			.antMatchers("/api/v1/produtos/**").hasRole("ADMIN")

			.anyRequest().authenticated()
			
				/*
				 * .and().formLogin() .loginPage("/login") .usernameParameter("email")
				 * .permitAll() .and() .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
				 * .and() .logout().permitAll()
				 */
    	
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);
		
        http.headers().frameOptions().sameOrigin();
        
        return http.build();
	}    
	
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }
	
}