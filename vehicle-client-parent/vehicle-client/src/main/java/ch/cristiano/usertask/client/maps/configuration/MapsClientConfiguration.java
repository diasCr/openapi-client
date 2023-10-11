package ch.cristiano.usertask.client.maps.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.maps.api.VehicleManagementApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MapsClientConfiguration {

    @Bean("vehicleRestTemplateMaps")
    public RestTemplate vehicleRestTemplateMaps(ObjectMapper objectMapper) {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
    }

    @Bean("vehicleApiClientMaps")
    public ApiClient vehicleApiClientMaps(ObjectMapper objectMapper) {
        return new ApiClient(vehicleRestTemplateMaps(objectMapper));
    }

    @Bean("vehicleManagementApiMaps")
    public VehicleManagementApi vehicleManagementApiMaps(ObjectMapper objectMapper) {
        return new VehicleManagementApi(vehicleApiClientMaps(objectMapper));
    }

}
