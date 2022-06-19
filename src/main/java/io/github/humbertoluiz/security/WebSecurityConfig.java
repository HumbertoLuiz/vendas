package io.github.humbertoluiz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.github.humbertoluiz.security.jwt.JWTFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Bean
	  PasswordEncoder passwordEncoder(){
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
    
	 @Override
    protected void configure(HttpSecurity http) throws Exception {
		 
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable()                
                .authorizeRequests()
                
                .antMatchers(SWAGGER_WHITELIST).permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/v1/clientes/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/pedidos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/produtos/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/users").permitAll()                                
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
        		.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
}