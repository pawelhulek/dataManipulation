package prv.hulek.data.manipulation.web.url;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-13.
 */
class UrlTemplateBuilderTest {

    private static ImmutableMap.Builder<String, String> paramsBuilder() {
        return ImmutableMap.builder();
    }

    @Test
    public void should_build_correct_url_with_port() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com", 8080);
        assertThat(builder.build().toUrl(correctParams().build()))
                .isEqualToIgnoringCase("http://www.website.com:8080/");
    }

    @Test
    public void should_build_correct_url_with_port_and_context() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com", 80).context("games");
        assertThat(builder.build().toUrl())
                .isEqualToIgnoringCase("http://www.website.com:80/games/");
    }

    @Test
    public void should_build_correct_url_with_context() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com").context("games");
        assertThat(builder.build().toUrl())
                .isEqualToIgnoringCase("http://www.website.com/games/");
    }

    @Test
    public void should_build_correct_url_with_context_and_query_param() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com").context("games").queryParam("user");
        ImmutableMap.Builder<String, String> params = paramsBuilder().put("user", "me");
        assertThat(builder.build().toUrl(params.build()))
                .isEqualToIgnoringCase("http://www.website.com/games/me/");
    }

    @Test
    public void should_build_correct_url_with_context_and_few_query_param() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com").context("games").queryParam("user").queryParam("gameType");
        ImmutableMap.Builder<String, String> params = paramsBuilder().put("user", "mine").put("gameType", "FPP");
        assertThat(builder.build().toUrl(params.build()))
                .isEqualToIgnoringCase("http://www.website.com/games/mine/FPP/");
    }

    @Test
    public void should_build_correct_url_with_context_and_few_query_param_with_redundant_parameters() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com").context("games").queryParam("user").queryParam("gameType");
        ImmutableMap.Builder<String, String> params = paramsBuilder().put("user", "mine").put("gameType", "FPP").put("year", "2000");
        assertThat(builder.build().toUrl(params.build()))
                .isEqualToIgnoringCase("http://www.website.com/games/mine/FPP/");
    }

    @Test
    public void should_build_correct_url_with_context_and_few_query_param_and_request_params() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com").context("games").queryParam("user")
                .queryParam("gameType").requestParam("year").requestParam("device");
        ImmutableMap.Builder<String, String> params = paramsBuilder().put("user", "mine")
                .put("gameType", "FPP").put("year", "2000").put("device", "android");
        assertThat(builder.build().toUrl(params.build()))
                .isEqualToIgnoringCase("http://www.website.com/games/mine/FPP/?year=2000&device=android");
    }

    @Test
    public void should_build_correct_url_with_segment() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com").pathSegment("games");
        assertThat(builder.build().toUrl(correctParams().build()))
                .isEqualToIgnoringCase("http://www.website.com/games/");
    }

    @Test
    public void should_build_correct_url_with_context_segment_queryParam_requestParam() {
        Templateable builder = UrlTemplateBuilder.of()
                .host("www.website.com")
                .context("games")
                .pathSegment("ubisoft")
                .queryParam("gameName")
                .requestParam("version");
        assertThat(builder.build().toUrl(correctParams().build()))
                .isEqualToIgnoringCase("http://www.website.com/games/ubisoft/Watch%20dogs/?version=1");
    }

    private ImmutableMap.Builder<String, String> correctParams() {
        return paramsBuilder().put("gameName", "Watch dogs").put("version", "1");
    }

    private Templateable correctUrlBuilder() {
        return UrlTemplateBuilder.of()
                .host("www.website.com")
                .context("games")
                .pathSegment("ubisoft")
                .queryParam("gameName")
                .requestParam("version");
    }

}