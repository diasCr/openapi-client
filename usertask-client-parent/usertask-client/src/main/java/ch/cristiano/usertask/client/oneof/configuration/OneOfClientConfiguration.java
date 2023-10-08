package ch.cristiano.usertask.client.oneof.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.oneof.api.UsertaskManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OneOfClientConfiguration {

    @Bean
    public ApiClient apiClientOneOf() {
        return new ApiClient();
    }

    @Bean
    public UsertaskManagementApi usertaskManagementApiOneOf() {
        return new UsertaskManagementApi(apiClientOneOf());
    }

}
