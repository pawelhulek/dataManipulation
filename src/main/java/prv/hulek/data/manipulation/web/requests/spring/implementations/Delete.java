package prv.hulek.data.manipulation.web.requests.spring.implementations;

import lombok.Builder;
import org.springframework.web.client.RestOperations;
import prv.hulek.data.manipulation.web.requests.base.DeleteOperation;
import prv.hulek.data.manipulation.web.requests.base.RequestParameters;
import prv.hulek.data.manipulation.web.url.URLTemplate;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Paweł Hulek on 28.06.17.
 */
public class Delete extends DeleteOperation{
    private final RestOperations restOperations;
    @Builder
    public Delete(URLTemplate url, RestOperations restOperations) {
        super(url);
        this.restOperations = restOperations;
    }

    @Override
    public Optional<Void> send(RequestParameters<Void> requestParameters) {
        restOperations.delete(url.toUrl(requestParameters.getParameters()));
        return Optional.empty();
    }
}
