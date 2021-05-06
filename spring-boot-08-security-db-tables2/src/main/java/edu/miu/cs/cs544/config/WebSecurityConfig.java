package edu.miu.cs.cs544.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     
	private static final String USERNAME_QUERY = "SELECT u.username AS [username], u.password AS [password], u.enabled AS [enabled]"
			+ "  FROM [User] u "
			+ "  WHERE u.username = ?";
	
	private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT u.username AS [username], 'ROLE_' + u.role AS [role]"
			+ "  FROM [User] u"
			+ "  WHERE u.username =?";
 
    @Autowired
    private DataSource dataSource;
     
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = new BCryptPasswordEncoder();
        
        auth.inMemoryAuthentication()
    		.passwordEncoder(encoder)
    		.withUser("service")
    		.password(encoder.encode("123"))
    		.roles("Service");
    	
        auth.jdbcAuthentication()        	
        	//.passwordEncoder(encoder) 
            .dataSource(dataSource)
            .usersByUsernameQuery(USERNAME_QUERY)
            .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http		
		.authorizeRequests()
			.antMatchers("/favicon.ico").permitAll()
			.antMatchers("/cars/**").hasAnyRole("Service", "admin")
			.antMatchers("/users/**").hasRole("admin")
			.anyRequest().authenticated()
			.and()
		.formLogin();
    }
    
}

