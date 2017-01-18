package prv.hulek.data.manipulation.web.url;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
@Data
@RequiredArgsConstructor
public class Host implements PathSegment {
    private final String host;
    private final Port port;

    public Host(String host, Integer port) {
        this.host = host;
        this.port = new Port(port);
    }

    @Override
    public String toUrlSegment() {
        return PathSegment.endsOnSlash(getHost() + getPort().toUrlSegment());
    }

}
