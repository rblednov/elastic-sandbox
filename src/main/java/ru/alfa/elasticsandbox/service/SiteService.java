package ru.alfa.elasticsandbox.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.alfa.elasticsandbox.dto.SitePage;

@Service
@AllArgsConstructor
public class SiteService {
    private final RestTemplate restTemplate;

    public List<String> getPageUrlList() {
        return List.of("/", "/sme/");
    }

    public SitePage getHtmlPageByUrl(String url) {
        Map<String, List<String>> requestHeaders = new HashMap<>();
        HttpEntity httpEntity = new HttpEntity(requestHeaders);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://preprod.ci.k8ng.alfa.link" + url,
                        HttpMethod.GET,
                        httpEntity,
                        String.class);
        return SitePage.builder()
                .htmlBody(responseEntity.getBody())
                .url(url)
                .headers(responseEntity.getHeaders())
                .build();
    }
}
