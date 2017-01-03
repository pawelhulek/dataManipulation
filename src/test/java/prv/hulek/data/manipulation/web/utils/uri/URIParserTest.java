package prv.hulek.data.manipulation.web.utils.uri;


import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by FEREWER on 2017-01-03.
 */
class URIParserTest {
    /*POSITIVE TESTS*/
    @Test
    public void should_parse_correct_url_string_without_parameters() {
        String googleUrl = "www.google.com";
        assertThat(URIParser.parse(googleUrl, Collections.<String, String>emptyMap())).isEqualTo(URI.create(googleUrl));
    }

    @Test
    public void should_parse_correct_url_string_with_parameter() {
        String googleUrl = "www.google.com/?lang=${lang}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "pl");
        assertThat(URIParser.parse(googleUrl, params)).isEqualTo(URI.create("www.google.com/?lang=pl"));
    }

    @Test
    public void should_parse_correct_url_string_with_few_parameters() {
        String googleUrl = "www.google.com/?lang=${lang}&location=${location}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "pl");
        params.put("location", "Cracov");
        assertThat(URIParser.parse(googleUrl, params)).isEqualTo(URI.create("www.google.com/?lang=pl&location=Cracov"));
    }

    @Test
    public void should_parse_correct_url_string_with_query_parameter() {
        String googleUrl = "www.google.com/${lang}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "pl");
        assertThat(URIParser.parse(googleUrl, params)).isEqualTo(URI.create("www.google.com/pl"));
    }

    @Test
    public void should_parse_correct_url_string_with_few_query_parameters() {
        String googleUrl = "www.google.com/${lang}/${location}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "pl");
        params.put("location", "Cracov");
        assertThat(URIParser.parse(googleUrl, params)).isEqualTo(URI.create("www.google.com/pl/Cracov"));
    }

    /*NEGATIVE TESTS*/
    @Test
    public void should_throw_exception_when_url_is_not_fully_parsed() {
        String googleUrl = "www.google.com/${lang}/${location}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "pl");
        assertThatThrownBy(() -> URIParser.parse(googleUrl, params)).isInstanceOf(IllegalArgumentException.class);
    }
}