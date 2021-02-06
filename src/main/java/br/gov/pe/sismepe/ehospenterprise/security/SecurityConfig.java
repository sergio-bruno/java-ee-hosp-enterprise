package br.gov.pe.sismepe.ehospenterprise.security;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.gov.pe.sismepe.ehospenterprise.security.authentication.AutenticacaoSismepe;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages= 
		{"br.gov.pe.sismepe.ehospenterprise.security.authentication", 
		"br.gov.pe.sismepe.ehospenterprise.security.service",
		"br.gov.pe.sismepe.ehospenterprise.dao"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Inject
	private AutenticacaoSismepe autenticacaoLocadora;
	
	//@Inject
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(autenticacaoLocadora);
	}
	
	@Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**")
	         .antMatchers("/javax.faces.resource/**"); 
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/acessoNegado.xhtml")
			.and()
			.authorizeRequests()
			.antMatchers("/administracao/**").hasRole("ADM_SITE")
			.anyRequest().authenticated()
			.and()
			.logout().logoutSuccessUrl("/login.xhtml?logout")
			.permitAll()
			.and()
			.formLogin().loginPage("/login.xhtml")
			.failureUrl("/login.xhtml?erro")
			.permitAll();
	}
}