package ch.cristiano.usertask.client.maps.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.maps.api.UsertaskManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapsClientConfiguration {

    @Bean
    public ApiClient apiClientMaps() {
        return new ApiClient();
    }

    @Bean
    public UsertaskManagementApi usertaskManagementApiMaps() {
        return new UsertaskManagementApi(apiClientMaps());
    }

}
