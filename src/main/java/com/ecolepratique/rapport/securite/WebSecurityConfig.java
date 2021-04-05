package com.ecolepratique.rapport.securite;

import java.time.Duration;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
        
        // Toutes les requêtes envoyées a serveur web doivent être authentifiées
        http.authorizeRequests().anyRequest().authenticated();
 
        // Use AuthenticationEntryPoint to authenticate user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);        
        
    }
    
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-CSRF-TOKEN"));
//        configuration.setExposedHeaders(Arrays.asList("Location", "Content-Disposition", "X-CSRF-TOKEN"));
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5501", "http://127.0.0.1:5501"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
//        configuration.setMaxAge(Duration.ofMinutes(86400));
//        configuration.setAllowCredentials(true);
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

 /*
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    */
}
