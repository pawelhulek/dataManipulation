package prv.hulek.data.manipulation.web.url;

import lombok.RequiredArgsConstructor;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
@RequiredArgsConstructor
public class Segment implements PathSegment {
    private final String segment;

    @Override
    public String toUrlSegment() {
        return PathSegment.endsOnSlash(segment);
    }
}
