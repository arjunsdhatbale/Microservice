package com.main;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        Instant start = Instant.now();
        String requestPath = exchange.getRequest().getPath().toString();

        System.out.println("[LOG] Incoming request: " + requestPath);
        exchange.getRequest().getHeaders().forEach((key, value) -> {
            System.out.println("[LOG] Header: " + key + " = " + value);
        });

        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Instant end = Instant.now();
                    Duration timeTaken = Duration.between(start, end);

                    System.out.println("[LOG] Completed request: " + requestPath + " | Time Taken: " + timeTaken.toMillis() + " ms");
                })
        );
    }

    // Lower order = higher priority. Default is 0, higher numbers go later.
    @Override
    public int getOrder() {
        return -1;
    }
}
