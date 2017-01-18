package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.Host;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-14.
 */
public class HostChainTemplateBuilder extends UrlTemplateBuilder {

    public HostChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    public ContextChainTemplateBuilder host(String host) {
        urlTemplate.add(new Host(host, (Integer) null));
        return new ContextChainTemplateBuilder(urlTemplate);
    }

    public ContextChainTemplateBuilder host(String host, Integer port) {
        urlTemplate.add(new Host(host, port));
        return new ContextChainTemplateBuilder(urlTemplate);
    }


}
