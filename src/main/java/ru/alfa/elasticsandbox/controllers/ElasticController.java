package ru.alfa.elasticsandbox.controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.alfa.elasticsandbox.dto.pageindex.SitePage;
import ru.alfa.elasticsandbox.service.SiteService;
import ru.alfa.elasticsandbox.index.FullPageIndex;

@Service
@RestController
@AllArgsConstructor
public class ElasticController {

    private final FullPageIndex fullPageIndex;
    private final SiteService siteService;

    @GetMapping("/utils/refresh/")
    public String getData(@RequestParam(value = "indexId", required = false) String indexId) {
        List<String> pageUrlList = siteService.getPageUrlList();

//        pageUrlList.stream()
//                .map(siteService::getHtmlPageByUrl)
//                .map(fullPageIndex::createIndexQueryForHtmlPage)
//                .forEach(fullPageIndex::indexFullHtmlPageByQuery);

        pageUrlList.stream()
                .map(siteService::getJsonPageByUrl)
                .map(fullPageIndex::createIndexQueryForJsonPage)
                .forEach(fullPageIndex::indexFullJsonPageByQuery);

        return "all indexed";
    }


    @GetMapping("/utils/delete/")
    public String delete(@RequestParam(value = "indexId") String indexId) {
        if (indexId != null) {
            fullPageIndex.deleteIndex(indexId);
        }
        return "index " + indexId + " deleted";
    }

    @GetMapping("/search/")
    public SearchHits<SitePage> search(@RequestParam String queryString, @RequestParam String indexId) {
        return fullPageIndex.search(queryString, indexId);
    }
}
