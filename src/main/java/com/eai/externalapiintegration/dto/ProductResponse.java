package com.eai.externalapiintegration.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductResponse(Long id, String title, BigDecimal price, Integer stock) {
}
