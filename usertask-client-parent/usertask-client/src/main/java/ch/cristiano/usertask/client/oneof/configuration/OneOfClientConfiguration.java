package ch.cristiano.usertask.client.oneof.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.client.ApiClient;
import org.openapitools.client.oneof.api.UsertaskManagementApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OneOfClientConfiguration {

    @Bean("usertaskRestTemplateOneOf")
    public RestTemplate usertaskRestTemplateOneOf(ObjectMapper objectMapper) {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
    }

    @Bean("usertaskApiClientOneOf")
    public ApiClient usertaskApiClientOneOf(ObjectMapper objectMapper) {
        return new ApiClient(usertaskRestTemplateOneOf(objectMapper));
    }

    @Bean("usertaskManagementApiOneOf")
    public UsertaskManagementApi usertaskManagementApiOneOf(ObjectMapper objectMapper) {
        return new UsertaskManagementApi(usertaskApiClientOneOf(objectMapper));
    }

}
