package ru.alfa.elasticsandbox.index;

import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import ru.alfa.elasticsandbox.dto.SitePage;

@Service
@AllArgsConstructor
public class FullHtmlPageIndex {
    private final ElasticsearchOperations elasticsearchOperations;
    private static final String FULL_HTML_PAGE_INDEX = "FullHtmlPageIndex";

    public IndexQuery createIndexQueryForHtmlPage(SitePage sitePage) {
        return new IndexQueryBuilder().withId(sitePage.getUrl()).withObject(sitePage).build();
    }

    public void indexFullHtmlPageByQuery(IndexQuery indexQuery) {
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of(FULL_HTML_PAGE_INDEX));
    }
}
