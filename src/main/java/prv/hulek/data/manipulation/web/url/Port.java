package prv.hulek.data.manipulation.web.url;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-18.
 */
@Data
@RequiredArgsConstructor
public class Port implements PathSegment {
    private final Integer port;

    @Override
    public String toUrlSegment() {
        return port == null ? "" : (":" + port.toString());
    }
}
