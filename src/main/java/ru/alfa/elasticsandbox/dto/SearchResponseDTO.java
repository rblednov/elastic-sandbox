package ru.alfa.elasticsandbox.dto;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import ru.alfa.elasticsandbox.dto.pageindex.SitePage;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class SearchResponseDTO {
    private final Float score;
    private final SitePage document;
    private final Map<String, List<String>> highlightFields;
}
