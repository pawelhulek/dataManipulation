package prv.hulek.data.manipulation.web.requests.base;

import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
public abstract class DeleteOperation implements HttpOperations<Void, Void> {
    protected final UrlTemplateBuilder url;
    protected final Map<String, String> params;

    public DeleteOperation(UrlTemplateBuilder url,
                           Map<String, String> params) {
        this.url = url;
        this.params = params;
    }
}
