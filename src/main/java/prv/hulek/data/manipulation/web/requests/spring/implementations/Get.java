package prv.hulek.data.manipulation.web.requests.spring.implementations;

import org.springframework.web.client.RestOperations;
import prv.hulek.data.manipulation.web.requests.base.GetOperation;
import prv.hulek.data.manipulation.web.requests.base.RequestParameters;
import prv.hulek.data.manipulation.web.url.URLTemplate;

import java.util.Optional;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
public class Get<RESPONSE> extends GetOperation<RESPONSE> {

    private final RestOperations restOperations;
    private final Class<RESPONSE> responseClass;

    public Get(URLTemplate url,
               RestOperations restOperations,
               Class<RESPONSE> responseClass) {
        super(url);
        this.restOperations = restOperations;
        this.responseClass = responseClass;
    }

    @Override
    public Optional<RESPONSE> send(RequestParameters<Void> requestParameters) {
        return Optional.ofNullable(restOperations.getForObject(url.toUrl(requestParameters.getParameters()), responseClass));
    }

}
