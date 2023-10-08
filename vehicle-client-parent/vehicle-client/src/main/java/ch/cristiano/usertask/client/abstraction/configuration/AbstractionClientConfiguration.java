package ch.cristiano.usertask.client.abstraction.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.abstraction.api.VehicleManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbstractionClientConfiguration {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean
    public VehicleManagementApi vehicleManagementApi() {
        return new VehicleManagementApi(apiClient());
    }

}
