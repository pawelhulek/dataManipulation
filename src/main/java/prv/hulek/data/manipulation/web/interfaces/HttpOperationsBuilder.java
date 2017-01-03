package prv.hulek.data.manipulation.web.interfaces;

import java.net.URI;

/**
 * Created by FEREWER on 2017-01-03.
 */
public interface HttpOperationsBuilder<RESPONSE, REQUEST> {
    HttpOperationsBuilder<RESPONSE, REQUEST> url(URI uri);

    RESPONSE get();

    void post(REQUEST request);

    void delete();

    void put(REQUEST request);
}
