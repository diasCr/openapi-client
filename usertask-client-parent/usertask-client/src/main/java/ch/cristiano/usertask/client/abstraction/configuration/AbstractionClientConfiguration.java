package ch.cristiano.usertask.client.abstraction.configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.abstraction.api.UsertaskManagementApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbstractionClientConfiguration {

    @Bean
    public ApiClient apiClientAbstraction() {
        return new ApiClient();
    }

    @Bean
    public UsertaskManagementApi usertaskManagementApiAbstraction() {
        return new UsertaskManagementApi(apiClientAbstraction());
    }

}
