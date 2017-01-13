package prv.hulek.data.manipulation.web.url;


import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-06.
 */
@NoArgsConstructor(staticName = "of")
public class UrlBuilder {
    private Host host;
    private Context context;
    private List<QueryParam> queryParams = new ArrayList<>();
    private List<RequestParam> params = new ArrayList<>();
    private URL url = new URL();

    public UrlBuilder host(String host) {
        if (this.host == null) {
            this.host = new Host(host);
            url.add(this.host);
        } else
            throw new IllegalArgumentException("host can be set only once and first");

        return this;
    }

    public UrlBuilder context(String context) {
        if (this.host == null) {
            throw new IllegalArgumentException("host have to be set first");
        } else if (this.context != null) {
            throw new IllegalArgumentException("context can be set only once");
        } else {
            this.context = new Context(context);
            this.url.add(this.context);
        }
        return this;
    }

    public UrlBuilder pathSegment(String segment) {
        this.url.add(new Segment(segment));
        return this;
    }

    public UrlBuilder queryParam(String queryParam) {
        QueryParam queryParameter = new QueryParam(queryParam);
        this.queryParams.add(queryParameter);
        url.add(queryParameter);
        return this;
    }

    public UrlBuilder requestParam(String param) {
        RequestParam urlParameter = new RequestParam(param);
        url.add(urlParameter);
        this.params.add(urlParameter);
        return this;
    }

    public URI buildURI(Map<String, String> params) {
        return URI.create(url.toUrl(params));
    }

    public String buildStringURL(Map<String, String> params) {
        return url.toUrl(params);
    }

}
