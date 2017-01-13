package prv.hulek.data.manipulation.web.url;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-13.
 */
class UrlBuilderTest {
    @Test
    public void should_build_correct_url() {
        UrlBuilder builder = correctUrlBUilder();
        assertThat(builder.buildStringURL(correctParams().build()))
                .isEqualToIgnoringCase("www.website.com/games/ubisoft/Watch%20dogs/?version=1");
    }

    private ImmutableMap.Builder<String, String> correctParams() {
        return ImmutableMap.<String, String>builder().put("gameName", "Watch dogs").put("version", "1");
    }

    private UrlBuilder correctUrlBUilder() {
        return UrlBuilder.of()
                .host("www.website.com")
                .context("games")
                .pathSegment("ubisoft")
                .queryParam("gameName")
                .requestParam("version");
    }

}