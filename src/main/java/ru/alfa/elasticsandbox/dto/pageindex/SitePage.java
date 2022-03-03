package ru.alfa.elasticsandbox.dto.pageindex;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import static ru.alfa.elasticsandbox.index.FullPageIndex.FULL_JSON_PAGE_INDEX;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(indexName = FULL_JSON_PAGE_INDEX)
public class SitePage {
    @Field(type = FieldType.Auto)
    private final String body;
    @Id
    private final String url;
    private final Map<String, List<String>> headers;
}
