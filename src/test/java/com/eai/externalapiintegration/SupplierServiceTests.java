package com.eai.externalapiintegration;

import java.math.BigDecimal;

import com.eai.externalapiintegration.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class SupplierServiceTests {

    @Test
    void mapsSupplierJsonToProductAndIgnoresExtraFields() {
        var builder = RestClient.builder().baseUrl("https://supplier.example");
        var server = MockRestServiceServer.bindTo(builder).build();
        var service = new SupplierService(builder.build());

        server.expect(requestTo("https://supplier.example/products/1"))
                .andRespond(withSuccess("""
                        {"id":1,"title":"Desk lamp","price":19.99,"stock":5,"description":"Extra field"}
                        """, MediaType.APPLICATION_JSON));

        var product = service.getProduct(1);

        assertThat(product).isNotNull();
        assertThat(product.id()).isEqualTo(1L);
        assertThat(product.title()).isEqualTo("Desk lamp");
        assertThat(product.price()).isEqualByComparingTo(new BigDecimal("19.99"));
        assertThat(product.stock()).isEqualTo(5);
        server.verify();
    }
}
