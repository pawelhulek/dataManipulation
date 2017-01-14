package prv.hulek.data.manipulation.web.url;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
public class URLTemplate extends LinkedList<PathSegment> {

    public String toUrl(Map<String, String> parameters) {
        AtomicBoolean isFirstQueryParameter = new AtomicBoolean(true);
        return this.stream()
                .peek(segment -> {
                    if (segment instanceof Parameter)
                        processParameters((Parameter) segment, parameters, isFirstQueryParameter);
                })
                .map(PathSegment::toUrlSegment)
                .reduce("", String::concat);
    }

    private void processParameters(Parameter segment,
                                   Map<String, String> parameters,
                                   AtomicBoolean isFirstQueryParameter) {
        segment.setValue(parameters.get(segment.getName()));
        if (isFirstQueryParameter.get() && segment instanceof RequestParam) {
            segment.setFirst(isFirstQueryParameter.get());
            isFirstQueryParameter.set(false);
        }
    }
}
