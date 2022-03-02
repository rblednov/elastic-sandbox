package ru.alfa.elasticsandbox.index;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import ru.alfa.elasticsandbox.dto.SearchResponseDTO;
import ru.alfa.elasticsandbox.dto.pageindex.SitePage;

@Service
@AllArgsConstructor
public class FullPageIndex {
    private final ElasticsearchOperations elasticsearchOperations;
    private static final String FULL_JSON_PAGE_INDEX = "json_index_01";
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

    public SearchHits<SitePage> search(String queryString, String indexId) {

        QueryBuilder searchQuery = QueryBuilders.multiMatchQuery("body", queryString)
                .fuzziness("AUTO");

        return elasticsearchOperations
                .search(searchQuery, SitePage.class,
                        IndexCoordinates.of(indexId));

    }
}
