package ch.cristiano.usertask.client.oneof.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.oneof.api.VehicleManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OneOfClientConfiguration {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean
    public VehicleManagementApi vehicleManagementApi() {
        return new VehicleManagementApi(apiClient());
    }

}
