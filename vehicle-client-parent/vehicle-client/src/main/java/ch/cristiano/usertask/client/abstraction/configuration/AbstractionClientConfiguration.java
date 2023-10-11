package ch.cristiano.usertask.client.abstraction.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.abstraction.api.VehicleManagementApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AbstractionClientConfiguration {

    @Bean("vehicleRestTemplateAbstraction")
    public RestTemplate vehicleRestTemplateAbstraction(ObjectMapper objectMapper) {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
    }

    @Bean("vehicleApiClientAbstraction")
    public ApiClient vehicleApiClientAbstraction(ObjectMapper objectMapper) {
        return new ApiClient(vehicleRestTemplateAbstraction(objectMapper));
    }

    @Bean("vehicleManagementApiAbstraction")
    public VehicleManagementApi vehicleManagementApiAbstraction(ObjectMapper objectMapper) {
        return new VehicleManagementApi(vehicleApiClientAbstraction(objectMapper));
    }
}
