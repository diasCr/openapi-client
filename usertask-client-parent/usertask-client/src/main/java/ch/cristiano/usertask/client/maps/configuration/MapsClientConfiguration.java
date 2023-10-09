package ch.cristiano.usertask.client.maps.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.client.ApiClient;
import org.openapitools.client.maps.api.UsertaskManagementApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MapsClientConfiguration {

    @Bean("restTemplateMaps")
    public RestTemplate restTemplateMaps(ObjectMapper objectMapper) {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
    }

    @Bean("apiClientMaps")
    public ApiClient apiClientMaps(ObjectMapper objectMapper) {
        return new ApiClient(restTemplateMaps(objectMapper));
    }

    @Bean("usertaskManagementApiMaps")
    public UsertaskManagementApi usertaskManagementApiMaps(ObjectMapper objectMapper) {
        return new UsertaskManagementApi(apiClientMaps(objectMapper));
    }

}
