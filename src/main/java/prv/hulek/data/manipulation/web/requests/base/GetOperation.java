package prv.hulek.data.manipulation.web.requests.base;

import lombok.AllArgsConstructor;
import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.UrlBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
@AllArgsConstructor
public abstract class GetOperation<RS> implements HttpOperations<Void, RS> {
    protected final UrlBuilder url;
    protected final Map<String, String> params;

}
