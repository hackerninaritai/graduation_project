package com.example.demo;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private DataSource dataSource;
	@Value("${spring.queries.account-query}")
	private String accountQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(accountQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/resources/**").permitAll()
								.antMatchers("/bootstrap/**").permitAll()
								.antMatchers("/dist/**").permitAll()
								.antMatchers("/plugins/**").permitAll()
								.antMatchers("/css/**").permitAll()
								.antMatchers("/js/**").permitAll()
								.antMatchers("/images/**").permitAll()
								.antMatchers("/login").permitAll()
								.antMatchers("/registration").permitAll()
								.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable()
				.formLogin().loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/welcome").usernameParameter("email").passwordParameter("password").and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
				.exceptionHandling().accessDeniedPage("/403");
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "//**", "/images/**", "bootstrap/**", "dist/**", "plugins/**");
		web.ignoring().antMatchers("/resources/**");
	}
}
