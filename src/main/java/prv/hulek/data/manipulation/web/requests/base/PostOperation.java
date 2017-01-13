package prv.hulek.data.manipulation.web.requests.base;

import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.UrlBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
public abstract class PostOperation<RQ, RS> implements HttpOperations<RQ, RS> {
    protected final UrlBuilder url;
    protected final Map<String, String> params;
    protected final RQ requestObject;

    public PostOperation(UrlBuilder url,
                         Map<String, String> params,
                         RQ requestObject) {
        this.url = url;
        this.params = params;
        this.requestObject = requestObject;
    }

}
