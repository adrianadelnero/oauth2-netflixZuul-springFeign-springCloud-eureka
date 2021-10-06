/**
 * 
 */
package com.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("adnr");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable().authorizeRequests().anyRequest().authenticated();
		//http.anonymous().disable().csrf().disable().authorizeRequests().anyRequest().authenticated();
/*		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll().and().authorizeRequests()
				.antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access","/oauth/token", "/logout").permitAll().anyRequest()
				.authenticated().and().csrf().disable();*/
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll().and().authorizeRequests()
				.antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access","/oauth/token").permitAll().anyRequest()
				.authenticated().and().csrf().disable();

	}
	
}
