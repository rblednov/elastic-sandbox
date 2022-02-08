package ru.alfa.elasticsandbox.controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.alfa.elasticsandbox.service.SiteService;
import ru.alfa.elasticsandbox.index.FullHtmlPageIndex;

@Service
@RestController
@AllArgsConstructor
public class ElasticController {

    private final FullHtmlPageIndex fullHtmlPageIndex;
    private final SiteService siteService;

    @GetMapping("/utils/refresh/")
    public String getData() {
        List<String> pageUrlList = siteService.getPageUrlList();

        pageUrlList.stream()
                .map(siteService::getHtmlPageByUrl)
                .map(fullHtmlPageIndex::createIndexQueryForHtmlPage)
                .forEach(fullHtmlPageIndex::indexFullHtmlPageByQuery);

        return "all indexed";
    }

    @GetMapping
    public String search(@RequestParam String query){

    }
}
