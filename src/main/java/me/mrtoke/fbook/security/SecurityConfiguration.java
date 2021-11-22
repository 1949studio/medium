package me.mrtoke.fbook.security;





import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username, password, enabled from members where username = ?1 OR email = ?1")
			.authoritiesByUsernameQuery("select username, role from members where username = ?");
		//option 2
		//		auth.jdbcAuthentication().dataSource(dataSource)
//		.withDefaultSchema()
//		.withUser("myuser")
//		.password("pass")
//		.roles("user")
//		.and()
//		.withUser("jackptoke")
//		.password("password")
//		.roles("user")
//		.and()
//		.withUser("amytoke")
//		.password("password")
//		.roles("ADMIN");

		//option 1
//		auth.inMemoryAuthentication()
//		.withUser("myuser")
//		.password("pass")
//		.roles("user")
//		.and()
//		.withUser("jackptoke")
//		.password("password")
//		.roles("user")
//		.and()
//		.withUser("amytoke")
//		.password("password")
//		.roles("ADMIN");
	}
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.formLogin();//.loginPage("/login")
		http.authorizeRequests()
		.antMatchers("/**").permitAll();
//			.antMatchers("/articles/new").hasRole("WRITER")
//			.antMatchers("/h2_console/**").permitAll()
//			.antMatchers("/", "/**").permitAll();//.authenticated();
//		.formLogin()
//			.loginPage("/login")
//			.permitAll()
//			.and()
//		.logout()
//			.permitAll();
//		http.exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

}
