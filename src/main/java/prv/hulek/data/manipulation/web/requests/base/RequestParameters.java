package prv.hulek.data.manipulation.web.requests.base;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-02-03.
 */
@Getter
public class RequestParameters<REQUEST> {
    private final REQUEST body;
    private final Map<String, String> parameters;

    @Builder
    public RequestParameters(REQUEST body, Map<String, String> parameters) {
        this.body = body;
        this.parameters = Collections.unmodifiableMap(parameters);
    }
}
