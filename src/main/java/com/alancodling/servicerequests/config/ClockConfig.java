package com.alancodling.servicerequests.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Registers a Clock bean so the service can ask "what time is it?" through an injected
 * dependency instead of calling Instant.now() directly. In production it's the real UTC
 * clock. In unit tests we pass Clock.fixed(...), so timestamps are predictable and assertable.
 */
@Configuration
public class ClockConfig {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
