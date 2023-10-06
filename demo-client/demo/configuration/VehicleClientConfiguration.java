package ch.swisscard.demo.demo.client.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.VehicleManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleClientConfiguration {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean
    public VehicleManagementApi usertaskManagementApi() {
        return new VehicleManagementApi(apiClient());
    }

}
