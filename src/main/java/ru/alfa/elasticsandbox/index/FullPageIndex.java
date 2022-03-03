package ru.alfa.elasticsandbox.index;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import ru.alfa.elasticsandbox.dto.pageindex.SitePage;

@Service
@AllArgsConstructor
public class FullPageIndex {
    private final ElasticsearchOperations elasticsearchOperations;

    public static final String FULL_JSON_PAGE_INDEX = "json_index_01";
    private static final String FULL_HTML_PAGE_INDEX = "html_index_01";

    public IndexQuery createIndexQueryForHtmlPage(SitePage sitePage) {
        return new IndexQueryBuilder().withId(sitePage.getUrl()).withObject(sitePage).build();
    }

    public IndexQuery createIndexQueryForJsonPage(SitePage sitePage) {
        return new IndexQueryBuilder().withId(sitePage.getUrl()).withObject(sitePage).build();
    }

    public void indexFullHtmlPageByQuery(IndexQuery indexQuery) {
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of(FULL_HTML_PAGE_INDEX));
    }

    public void indexFullJsonPageByQuery(IndexQuery indexQuery) {
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of(FULL_JSON_PAGE_INDEX));
    }

    public void deleteIndex(String indexId) {
        elasticsearchOperations.indexOps(IndexCoordinates.of(indexId)).delete();
    }

    @SneakyThrows
    public SearchHits<SitePage> search(String queryString, String indexId) {

        QueryBuilder searchQuery = QueryBuilders.matchQuery("body", queryString)
                .fuzziness("AUTO");

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(searchQuery).build();

        return elasticsearchOperations
                .search(nativeSearchQuery, SitePage.class, IndexCoordinates.of(FULL_JSON_PAGE_INDEX));
    }
}
