package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.QueryParam;
import prv.hulek.data.manipulation.web.url.RequestParam;
import prv.hulek.data.manipulation.web.url.Segment;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-14.
 */
public class SegmentChainTemplateBuilder extends UrlTemplateBuilder {

    SegmentChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    public SegmentChainTemplateBuilder pathSegment(String segment) {
        this.urlTemplate.add(new Segment(segment));
        return this;
    }

    public SegmentChainTemplateBuilder queryParam(String queryParam) {
        QueryParam queryParameter = new QueryParam(queryParam);
        this.urlTemplate.add(queryParameter);
        return this;
    }

    public RequestParameterChainTemplateBuilder requestParam(String param) {
        this.urlTemplate.add(new RequestParam(param));
        return new RequestParameterChainTemplateBuilder(urlTemplate);
    }

}
