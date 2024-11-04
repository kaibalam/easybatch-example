package com.ericsson.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ericsson.crm.security.JwtAuthenticationEntryPoint;
import com.ericsson.crm.security.JwtAuthenticationFilter;
import com.ericsson.crm.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/**/authorization").permitAll()
				.antMatchers("/**/listadoCampanias/**").permitAll()
				.antMatchers("/**/campanias/**").permitAll()
				.antMatchers("/**/campanias-add/**").permitAll()
				.antMatchers("/**/detalleCampanias/**").permitAll()
				.antMatchers("/**/tipo_producto/**").permitAll()
				.antMatchers("/**/**").permitAll()
				.antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.html",
						"/**/*.css", "/**/*.js", "/**/*.ttf", "/**/*.woff", "/**/*.woff2", "/**/*.webp")
				.permitAll().anyRequest().authenticated().and().cors().and().csrf().and().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
		http.headers().frameOptions().disable();
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
