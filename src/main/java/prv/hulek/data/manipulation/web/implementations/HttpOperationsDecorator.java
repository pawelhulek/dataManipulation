package prv.hulek.data.manipulation.web.implementations;

import prv.hulek.data.manipulation.web.interfaces.HttpOperationsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * Created by FEREWER on 2017-01-03.
 */
public class HttpOperationsDecorator<RQ, RS> implements HttpOperationsBuilder<RQ, RS> {
    private final HttpOperationsBuilder<RQ, RS> operationsBuilder;

    public HttpOperationsDecorator(HttpOperationsBuilder<RQ, RS> operationsBuilder) {
        this.operationsBuilder = operationsBuilder;
    }

    public HttpOperationsDecorator<RQ, RS> url(String url, Map<String, String> params) {
        URI.create(url);
        return this;

    }

    public HttpOperationsDecorator<RQ, RS> url(URI uri) {
        operationsBuilder.url(uri);
        return this;
    }

    public RQ get() {
        return operationsBuilder.get();
    }

    public void post(RS rs) {
        operationsBuilder.post(rs);
    }

    public void delete() {
        operationsBuilder.delete();
    }

    public void put(RS rs) {
        operationsBuilder.put(rs);
    }
}
