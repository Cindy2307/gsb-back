package com.ecolepratique.rapport.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.ecolepratique.rapport.RapportVisiteBdApplication;

public class WebInitialiser extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RapportVisiteBdApplication.class);
	}
}
