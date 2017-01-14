package prv.hulek.data.manipulation.web.requests.base;

import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
public abstract class PostOperation<RQ, RS> implements HttpOperations<RQ, RS> {
    protected final UrlTemplateBuilder url;
    protected final Map<String, String> params;
    protected final RQ requestObject;

    public PostOperation(UrlTemplateBuilder url,
                         Map<String, String> params,
                         RQ requestObject) {
        this.url = url;
        this.params = params;
        this.requestObject = requestObject;
    }

}
