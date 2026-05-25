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
                .route("test", r -> r
                        .path("/api/test/**")
                        .filters(f -> f.rewritePath("/api/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8001"))
//                .route("orders", r -> r
//                        .path("/api/orders/**")
//                        .filters(f -> f.rewritePath("/api/(?<segment>.*)", "/${segment}"))
//                        .uri("http://localhost:8002"))
                .build();
    }
}


