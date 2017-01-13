package prv.hulek.data.manipulation.web.url;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
public interface PathSegment {
    static String endsOnSlash(String segment) {
        if (segment.endsWith("/"))
            return segment;
        else
            return segment + "/";
    }

    String toUrlSegment();
}
