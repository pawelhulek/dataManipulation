package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-14.
 */
public class ContextChainTemplateBuilder extends SegmentChainTemplateBuilder {

    public ContextChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    /**
     * Method is simple segment, but gives readability to the API
     *
     * @see SegmentChainTemplateBuilder.pathSegment(segment)
     **/
    public SegmentChainTemplateBuilder context(String context) {
        return this.pathSegment(context);
    }

}
