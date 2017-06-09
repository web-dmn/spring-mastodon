package web.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Java on 2017/05/29.
 */
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
        supportedMediaTypes.add(MediaType.TEXT_PLAIN); // text/plainのJacksonの処理対象にくわえる
        messageConverter.setSupportedMediaTypes(supportedMediaTypes);
        restTemplate.setMessageConverters(Collections.singletonList(messageConverter)); // カスタムしたHttpMessageConverterを適用
        return restTemplate;
    }
}
