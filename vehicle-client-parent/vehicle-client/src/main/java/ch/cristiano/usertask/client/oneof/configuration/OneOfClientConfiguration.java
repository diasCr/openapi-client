package ch.cristiano.usertask.client.oneof.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.oneof.api.VehicleManagementApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class OneOfClientConfiguration {

    @Bean("vehicleRestTemplateOneOf")
    public RestTemplate vehicleRestTemplateOneOf(ObjectMapper objectMapper) {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
    }

    @Bean("vehicleApiClientOneOf")
    public ApiClient vehicleApiClientOneOf(ObjectMapper objectMapper) {
        return new ApiClient(vehicleRestTemplateOneOf(objectMapper));
    }

    @Bean("vehicleManagementApiOneOf")
    public VehicleManagementApi vehicleManagementApiOneOf(ObjectMapper objectMapper) {
        return new VehicleManagementApi(vehicleApiClientOneOf(objectMapper));
    }

}
