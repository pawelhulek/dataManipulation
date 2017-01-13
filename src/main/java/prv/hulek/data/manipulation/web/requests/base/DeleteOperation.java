package prv.hulek.data.manipulation.web.requests.base;

import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.UrlBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
public abstract class DeleteOperation implements HttpOperations<Void, Void> {
    protected final UrlBuilder url;
    protected final Map<String, String> params;

    public DeleteOperation(UrlBuilder url,
                           Map<String, String> params) {
        this.url = url;
        this.params = params;
    }
}
