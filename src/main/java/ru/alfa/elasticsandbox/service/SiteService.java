package ru.alfa.elasticsandbox.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.alfa.elasticsandbox.dto.pageindex.SitePage;

@Service
@AllArgsConstructor
public class SiteService {
    private final RestTemplate restTemplate;

    public List<String> getPageUrlList() {
        return List.of(
                "/",
                "/sme/",
                "/everyday/debit-cards/",
                "/cards/",
                "/make-money/",
                "/get-money/mortgage/",
                "/make-money/investments/",
                "/sme/profits-new/",
                "/sme/deposits/");
    }

    public SitePage getJsonPageByUrl(String url) {
        Map<String, List<String>> requestHeaders = new HashMap<>();
        HttpEntity httpEntity = new HttpEntity(requestHeaders);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://preprod.ci.k8ng.alfa.link/as-json" + url,
                        HttpMethod.GET,
                        httpEntity,
                        String.class);
        return SitePage.builder()
                .body(responseEntity.getBody())
                .url(url)
                .headers(responseEntity.getHeaders())
                .build();
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
                .body(responseEntity.getBody())
                .url(url)
                .headers(responseEntity.getHeaders())
                .build();
    }
}
