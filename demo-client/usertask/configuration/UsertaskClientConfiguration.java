package ch.swisscard.demo.demo.client.rest.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.UsertaskManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsertaskClientConfiguration {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean
    public UsertaskManagementApi usertaskManagementApi() {
        return new UsertaskManagementApi(apiClient());
    }

}
