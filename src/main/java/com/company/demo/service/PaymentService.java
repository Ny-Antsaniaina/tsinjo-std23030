package com.company.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class PaymentService {

    @Value("${vola.apiKey}")
    private String apiKey;

    private final WebClient webClient;

    public PaymentService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Map<String, Object>> getPayment(String email, String pspPaymentId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/payment")
                        .queryParam("apiKey", apiKey)
                        .queryParam("payerEmail", email)
                        .queryParam("pspType", "ORANGE_MONEY")
                        .queryParam("pspPaymentId", pspPaymentId)
                        .build())
                .retrieve()
                .bodyToMono(Map.class);
    }
}
