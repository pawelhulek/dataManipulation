package prv.hulek.data.manipulation.web.url.chain.builders;

import prv.hulek.data.manipulation.web.url.RequestParam;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-14.
 */
public class RequestParameterChainTemplateBuilder extends UrlTemplateBuilder {
    RequestParameterChainTemplateBuilder(URLTemplate urlTemplate) {
        super(urlTemplate);
    }

    public RequestParameterChainTemplateBuilder requestParam(String param) {
        this.urlTemplate.add(new RequestParam(param));
        return this;
    }

}
