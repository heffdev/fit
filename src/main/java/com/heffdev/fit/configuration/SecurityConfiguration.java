package com.heffdev.fit.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.heffdev.fit.util.HeffDevConstants;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);

	/**
	 * A logging <code>Logger</code> for writing log entries for the system
	 * execution time logs.
	 */
	private static Logger TIMELOG = LoggerFactory.getLogger(HeffDevConstants.TIME_LOGGER);

	/**
	 * A logging <code>Logger</code> for writing log entries for the system
	 * boundary logs.
	 */
	private static Logger LOGSYSBNDRY = LoggerFactory.getLogger(HeffDevConstants.SYS_BOUNDARY_LOGGER);

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/", "/products", "/fithealth", "/console/**").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();

		// httpSecurity.authorizeRequests().antMatchers("/login**").permitAll().antMatchers("/static/**",
		// "/webjars/**")
		// .permitAll().antMatchers("/about").permitAll().antMatchers("/admin/**").fullyAuthenticated()
		// .antMatchers("/").permitAll().and().formLogin().loginPage("/login").failureUrl("/login?error")
		// .successHandler(customLoginSuccessHandler).permitAll().and().logout()
		// .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		// .logoutSuccessHandler(customLogoutSuccessHandler).invalidateHttpSession(true)
		// .deleteCookies("JSESSIONID").permitAll();

		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and().withUser("user")
		// .password("user").roles("USER");
		auth.jdbcAuthentication().dataSource(this.dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");

	}

}