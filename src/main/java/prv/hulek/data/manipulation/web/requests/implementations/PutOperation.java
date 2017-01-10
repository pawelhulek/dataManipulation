package prv.hulek.data.manipulation.web.requests.implementations;

import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.utils.uri.UrlBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
public abstract class PutOperation<RQ, RS> implements HttpOperations<RQ, RS> {
    protected final UrlBuilder url;
    protected final Map<String, String> params;
    protected final RQ requestObject;

    public PutOperation(UrlBuilder url,
                        Map<String, String> params,
                        RQ requestObject) {
        this.url = url;
        this.params = params;
        this.requestObject = requestObject;
    }

}
