package com.eai.externalapiintegration.controller;

import com.eai.externalapiintegration.service.SupplierService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final SupplierService supplierService;

    public ProductController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = "/api/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProduct(@PathVariable("id") long productId) {
        return supplierService.getProduct(productId);
    }
}
