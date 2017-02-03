package prv.hulek.data.manipulation.web.requests.base;

import lombok.AllArgsConstructor;
import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
@AllArgsConstructor
public abstract class GetOperation<RS> implements HttpOperations<Void, RS> {
    protected final URLTemplate url;
}
