package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import web.app.persistence.entity.Status;
import web.app.persistence.property.MastodonProperties;

import java.util.List;

/**
 * Created by Java on 2017/05/29.
 */
@Service
public class TimelineSearchService {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public MastodonProperties properties;

    /**
     * パブリックタイムライン取得処理
     * @return
     */
    public List<Status> getPublicTimeline() {
        // HttpClientのヘッダー設定
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("Authorization", "Bearer "+ properties.getAccessToken());

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<Status>> data = restTemplate.exchange(
                properties.getPublicUrl(), HttpMethod.GET, entity
                , new ParameterizedTypeReference<List<Status>>(){
        });
        List<Status> toot = data.getBody();

        return toot;
    }

    /**
     * タグ検索処理
     * @param key
     */
    public ResponseEntity<List<Status>> getTagTimeline(String key) {

        // HttpClientのヘッダー設定
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("Authorization", "Bearer "+ properties.getAccessToken());

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<Status>> data = restTemplate.exchange(
                properties.getTimelineTag() + key + "?limit=10"
                , HttpMethod.GET, entity, new ParameterizedTypeReference<List<Status>>(){
        });

        return data;
    }
}
