package prv.hulek.data.manipulation.web.requests.spring.implementations;

import org.springframework.web.client.RestOperations;
import prv.hulek.data.manipulation.web.requests.base.GetOperation;
import prv.hulek.data.manipulation.web.url.UrlBuilder;

import java.util.Map;
import java.util.Optional;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
public class Get<RESPONSE> extends GetOperation<RESPONSE> {

    private final RestOperations restOperations;
    private final Class<RESPONSE> responseClass;

    public Get(UrlBuilder url,
               Map<String, String> params,
               RestOperations restOperations,
               Class<RESPONSE> responseClass) {
        super(url, params);
        this.restOperations = restOperations;
        this.responseClass = responseClass;
    }

    @Override
    public Optional<RESPONSE> send() {
        return Optional.ofNullable(restOperations.getForObject(url.buildURI(params), responseClass));
    }

}
