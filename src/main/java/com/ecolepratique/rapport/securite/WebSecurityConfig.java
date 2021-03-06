package com.ecolepratique.rapport.securite;

import java.util.Arrays;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(
		jsr250Enabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	// . . .
    @Autowired
    private AuthenticationEntryPoint authEntryPoint;
 
    @Autowired
	DataSource dataSource;
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select login as principal, password as credentials, "
					+ "active from user where login=?")
			.authoritiesByUsernameQuery("select login as principal, role as role "
										+ "from user_role where login=?")
			.passwordEncoder(new BCryptPasswordEncoder())
			.rolePrefix("ROLE_");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("WebSecurityConfig - configure");
    	// Permettre aprés modification de modifier des données 
        http.cors().and().csrf().disable();
        
        // Configurer les cors
        http.cors().configurationSource(request -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOriginPatterns(Arrays.asList("*"));
            cors.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(Arrays.asList("*"));
            cors.setAllowCredentials(true);
            return cors;
        });
        
        // Toutes les requêtes envoyées a serveur web doivent être authentifiées
        http.authorizeRequests().anyRequest().authenticated();
 
        // Use AuthenticationEntryPoint to authenticate user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);        
        
        // Configurer le logout
        http.logout().permitAll();
        http.logout().logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)));
        
        //h2 console
        http.headers().frameOptions().disable();
        }
}
