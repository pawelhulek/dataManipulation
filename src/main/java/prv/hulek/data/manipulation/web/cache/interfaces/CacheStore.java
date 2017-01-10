package prv.hulek.data.manipulation.web.cache.interfaces;

import java.net.URI;
import java.util.List;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-10.
 */
public interface CacheStore {
    List<URI> cachedKeys();

    default String contextKey() {
        return "";
    }
}
