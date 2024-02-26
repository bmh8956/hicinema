package com.himedia.hicinema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// http://localhost:9696/ 요청은 인증 없이 접근을 허용
				.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
						.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//						.requestMatchers(new AntPathRequestMatcher("/css/**\", \"/js/**\", \"/img/**")).permitAll()
//						.requestMatchers(new AntPathRequestMatcher("\"/members/**\", \"/item/**\", \"/images/**\"")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
				)

				// http://localhost:9696/h2-console 요청의 접근 을 허용   , h2 DB는 csrf 적용이안되어서 설정
				//.csrf().disable()   // 모든 csrf를 사용하지 않도록 설정
				.csrf((csrf)-> csrf
						.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
				)
				.headers((headers) -> headers
						.addHeaderWriter(new XFrameOptionsHeaderWriter(
								XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN
						))
				)
		;
		return http.build();
	}
}