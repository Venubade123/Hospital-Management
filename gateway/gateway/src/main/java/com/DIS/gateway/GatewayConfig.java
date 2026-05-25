package com.DIS.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                // ─── API Routes ───────────────────────────────────
                .route("test", r -> r
                        .path("/api/test/**")
                        .filters(f -> f.rewritePath("/api/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8001"))

                // ─── Swagger Doc Route ────────────────────────────
                // /aggregate/test/v3/api-docs → http://localhost:8001/test/v3/api-docs
                .route("test-swagger", r -> r
                        .path("/aggregate/test/**")
                        .filters(f -> f.rewritePath("/aggregate/test/(?<segment>.*)", "/test/${segment}"))
                        .uri("http://localhost:8001"))

                .build();
    }
}