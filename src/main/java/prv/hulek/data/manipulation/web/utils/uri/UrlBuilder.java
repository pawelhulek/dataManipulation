package prv.hulek.data.manipulation.web.utils.uri;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-06.
 */
public class UrlBuilder {
    private String host;
    private String context;
    private List<String> queryParams = new ArrayList<>();
    private List<String> params = new ArrayList<>();
    private List<String> url = new ArrayList<>();

    public UrlBuilder host(String host) {
        if (this.host == null) {
            this.host = host;
            url.add(host);
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
            this.context = context;
            this.url.add(context);
        }
        return this;
    }

    public UrlBuilder pathSegment(String segment) {
        this.url.add(segment);
        return this;
    }

    public UrlBuilder queryParam(String queryParam) {
        this.queryParams.add(queryParam);
        url.add("${" + queryParam + "}");
        return this;
    }

    public UrlBuilder param(String param) {
        if (param.isEmpty())
            url.add("/?" + param + "=${" + param + "}");
        else
            url.add("&" + param + "=${" + param + "}");

        this.params.add(param);
        return this;
    }

    public String build() {
        return String.join("", url);
    }


}
