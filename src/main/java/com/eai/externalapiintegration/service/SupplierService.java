package com.eai.externalapiintegration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SupplierService {

    private final RestClient supplierRestClient;

    public SupplierService(RestClient supplierRestClient) {
        this.supplierRestClient = supplierRestClient;
    }

    public String getProduct(long productId) {
        System.out.println(supplierRestClient.get());
        return supplierRestClient.get()
                .uri("/products/{id}", productId)
                .retrieve()
                .body(String.class);
    }
}
