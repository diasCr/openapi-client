package ch.cristiano.usertask.client.abstraction.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.client.ApiClient;
import org.openapitools.client.abstraction.api.UsertaskManagementApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AbstractionClientConfiguration {

    @Bean("restTemplateAbstraction")
    public RestTemplate restTemplateAbstraction(ObjectMapper objectMapper) {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
    }

    @Bean("apiClientAbstraction")
    public ApiClient apiClientAbstraction(ObjectMapper objectMapper) {
        return new ApiClient(restTemplateAbstraction(objectMapper));
    }

    @Bean("usertaskManagementApiAbstraction")
    public UsertaskManagementApi usertaskManagementApiAbstraction(ObjectMapper objectMapper) {
        return new UsertaskManagementApi(apiClientAbstraction(objectMapper));
    }

}
