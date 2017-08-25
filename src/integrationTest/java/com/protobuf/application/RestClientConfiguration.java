package com.protobuf.application;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

	@Bean
	RestTemplate restTemplate(ProtobufHttpMessageConverter pbhmc) {
		return new RestTemplate(Arrays.asList(pbhmc));
	}

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}
}
