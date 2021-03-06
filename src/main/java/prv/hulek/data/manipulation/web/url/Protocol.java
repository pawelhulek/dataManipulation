package prv.hulek.data.manipulation.web.url;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-18.
 */
public enum Protocol implements PathSegment {
    HTTP, HTTPS;

    @Override
    public String toUrlSegment() {
        return this.name().toLowerCase() + "://";
    }
}
