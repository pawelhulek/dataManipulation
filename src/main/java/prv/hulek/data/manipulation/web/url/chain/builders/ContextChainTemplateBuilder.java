package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.Context;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-14.
 */
public class ContextChainTemplateBuilder extends UrlTemplateBuilder {

    public ContextChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    public SegmentChainTemplateBuilder context(String context) {
        urlTemplate.add(new Context(context));
        return new SegmentChainTemplateBuilder(urlTemplate);
    }

}
