package com.dayary.elly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dayary.elly.common.interceptor.DayaryInterceptor;

@Configuration
public class WebMvcConfig {

	private final DayaryInterceptor dayaryInterceptor;

	public WebMvcConfig(DayaryInterceptor dayaryInterceptor) {
		this.dayaryInterceptor = dayaryInterceptor;
	}

	@Bean // SpringBoot2.x: WebMvcConfigurerAdapter -> WebMvcConfigurer
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
				registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(dayaryInterceptor).addPathPatterns("/**")
						.excludePathPatterns("/main", "/member/signUp", "/member/login",
								"/css/**", "/js/**", "/favicon.ico", "/error");
			}

		};
	}

	// SpringBoot2.1_ErrorPage처리
	/*
	 * @Bean public ErrorPageRegistrar serverProperties() { return (registry) -> {
	 * registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
	 * //400 registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
	 * "/error/404")); //404 registry.addErrorPages(new
	 * ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405")); //405
	 * registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
	 * "/error/500")); //500 }; }
	 */

}
