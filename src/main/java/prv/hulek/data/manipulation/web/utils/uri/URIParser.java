package prv.hulek.data.manipulation.web.utils.uri;

import java.net.URI;
import java.util.Map;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-03.
 */
public class URIParser {
    private URIParser() {
    }

    public static URI parse(String url, Map<String, String> params) {
        for (String value : params.keySet()) {
            url = url.replaceAll("\\$\\{" + value + "\\}", params.get(value));
        }
        return URI.create(url);
    }
}
