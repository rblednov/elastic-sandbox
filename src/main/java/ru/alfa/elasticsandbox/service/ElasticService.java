package ru.alfa.elasticsandbox.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.alfa.elasticsandbox.index.FullHtmlPageIndex;

@Service
@RestController
@AllArgsConstructor
public class ElasticService {

    private final FullHtmlPageIndex fullHtmlPageIndex;
    private final SiteService siteService;

    @GetMapping("/")
    public String getData() {
        List<String> pageUrlList = siteService.getPageUrlList();

        pageUrlList.stream()
                .map(siteService::getHtmlPageByUrl)
                .map(fullHtmlPageIndex::createIndexQueryForHtmlPage)
                .forEach(fullHtmlPageIndex::indexFullHtmlPageByQuery);

        return "all indexed";
    }
}
