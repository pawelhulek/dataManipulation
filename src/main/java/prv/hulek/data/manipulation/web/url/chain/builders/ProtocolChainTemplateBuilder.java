package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.Protocol;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-18.
 */
public class ProtocolChainTemplateBuilder extends HostChainTemplateBuilder {
    ProtocolChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    public HostChainTemplateBuilder http() {
        urlTemplate.add(Protocol.HTTP);
        return this;
    }

    public HostChainTemplateBuilder https() {
        urlTemplate.add(Protocol.HTTPS);
        return this;
    }

    @Override
    public ContextChainTemplateBuilder host(String host) {
        this.http();
        return super.host(host);
    }

    @Override
    public ContextChainTemplateBuilder host(String host, Integer port) {
        this.http();
        return super.host(host, port);
    }
}
