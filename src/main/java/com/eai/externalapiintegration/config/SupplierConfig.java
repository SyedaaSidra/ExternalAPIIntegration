package com.eai.externalapiintegration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class SupplierConfig {

    @Bean
    public RestClient supplierRestClient(RestClient.Builder builder,
            @Value("${supplier.base-url}") String baseUrl) {
        return builder.baseUrl(baseUrl).build();
    }
}
