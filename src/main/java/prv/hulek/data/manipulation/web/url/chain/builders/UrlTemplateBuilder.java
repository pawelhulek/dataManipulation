package prv.hulek.data.manipulation.web.url.chain.builders;


import prv.hulek.data.manipulation.web.url.PathSegment;
import prv.hulek.data.manipulation.web.url.Templateable;
import prv.hulek.data.manipulation.web.url.URLTemplate;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-06.
 */
public class UrlTemplateBuilder implements Templateable {
    protected final URLTemplate urlTemplate;

    public UrlTemplateBuilder(URLTemplate urlTemplate) {
        this.urlTemplate = urlTemplate;
    }

    public static SchemeHostChainTemplateBuilder of() {
        return new SchemeHostChainTemplateBuilder(new URLTemplate());
    }

    UrlTemplateBuilder add(PathSegment segment) {
        urlTemplate.add(segment);
        return this;
    }

    @Override
    public URLTemplate build() {
        return urlTemplate;
    }

}
