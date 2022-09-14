package com.boot.demo.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfiguration {

    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        KeyResolver a = exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        System.out.println(a);
        return a;
    }
}