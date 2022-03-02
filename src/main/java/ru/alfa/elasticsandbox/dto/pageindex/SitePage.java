package ru.alfa.elasticsandbox.dto.pageindex;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class SitePage {
    private final String body;
    private final String url;
    private final Map<String, List<String>> headers;
}
