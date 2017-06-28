package prv.hulek.data.manipulation.web.requests.base;

import lombok.RequiredArgsConstructor;
import prv.hulek.data.manipulation.web.requests.interfaces.HttpOperations;
import prv.hulek.data.manipulation.web.url.URLTemplate;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
@RequiredArgsConstructor
public abstract class DeleteOperation implements HttpOperations<Void, Void> {
    protected final URLTemplate url;

}
