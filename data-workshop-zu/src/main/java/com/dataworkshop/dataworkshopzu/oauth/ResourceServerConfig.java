/**
 * 
 */
package com.dataworkshop.dataworkshopzu.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author ramon
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/se/oauth/token").permitAll()
			.antMatchers(HttpMethod.GET, "/api/us/**").denyAll()
			.antMatchers(HttpMethod.POST,  "/api/us/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/be/**").permitAll()
			.antMatchers(HttpMethod.POST,  "/api/be/**").hasAnyRole("ADMIN", "USER")
			.antMatchers(HttpMethod.DELETE,  "/api/be/**").hasAnyRole("ADMIN", "USER")
			.antMatchers(HttpMethod.PUT,  "/api/be/**").hasAnyRole("ADMIN", "USER");
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("secret");
		return tokenConverter;
	}
	
}
