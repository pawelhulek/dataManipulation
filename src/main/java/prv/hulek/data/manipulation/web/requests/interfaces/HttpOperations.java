package prv.hulek.data.manipulation.web.requests.interfaces;


import prv.hulek.data.manipulation.web.requests.base.RequestParameters;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-10.
 */
public interface HttpOperations<REQUEST, RESPONSE> {

    Optional<RESPONSE> send(RequestParameters<REQUEST> requestParameters);

    default Optional<RESPONSE> send() {
        return send(RequestParameters.<REQUEST>builder().parameters(Collections.emptyMap()).build());
    }
    default Optional<RESPONSE> send(Map<String, String> parameters) {
        return send(RequestParameters.<REQUEST>builder().parameters(parameters).build());
    }

    default Optional<RESPONSE> send(REQUEST requestBody) {
        return send(RequestParameters.<REQUEST>builder().body(requestBody).build());
    }

    default CompletableFuture<Optional<RESPONSE>> sendAsync(RequestParameters<REQUEST> requestParameters) {
        return CompletableFuture.supplyAsync(() -> send(requestParameters));
    }

    default CompletableFuture<Optional<RESPONSE>> sendAsync(Map<String, String> parameters) {
        return CompletableFuture.supplyAsync(() -> send(parameters));
    }

    default CompletableFuture<Optional<RESPONSE>> sendAsync(REQUEST requestBody) {
        return CompletableFuture.supplyAsync(() -> send(requestBody));
    }


}
