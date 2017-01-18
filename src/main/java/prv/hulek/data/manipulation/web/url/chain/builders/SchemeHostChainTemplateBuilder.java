package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.Scheme;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-18.
 */
public class SchemeHostChainTemplateBuilder extends HostChainTemplateBuilder {
    public SchemeHostChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    public HostChainTemplateBuilder http() {
        urlTemplate.add(Scheme.HTTP);
        return this;
    }

    public HostChainTemplateBuilder https() {
        urlTemplate.add(Scheme.HTTPS);
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
