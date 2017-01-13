package prv.hulek.data.manipulation.web.requests.interfaces;


import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-10.
 */
public interface HttpOperations<REQUEST, RESPONSE> {

    Optional<RESPONSE> send();

    default CompletableFuture<Optional<RESPONSE>> sendAsync() {
        return CompletableFuture.supplyAsync(this::send);
    }


}
