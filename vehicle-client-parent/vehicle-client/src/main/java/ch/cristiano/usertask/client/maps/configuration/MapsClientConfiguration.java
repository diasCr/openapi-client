package ch.cristiano.usertask.client.maps.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.maps.api.VehicleManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapsClientConfiguration {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean
    public VehicleManagementApi vehicleManagementApi() {
        return new VehicleManagementApi(apiClient());
    }

}
