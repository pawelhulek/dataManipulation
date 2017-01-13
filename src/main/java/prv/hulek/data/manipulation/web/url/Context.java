package prv.hulek.data.manipulation.web.url;

import lombok.RequiredArgsConstructor;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
@RequiredArgsConstructor
public class Context implements PathSegment {
    private final String context;

    @Override
    public String toUrlSegment() {
        return PathSegment.endsOnSlash(context);
    }
}
