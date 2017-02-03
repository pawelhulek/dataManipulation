package prv.hulek.data.manipulation.web.requests.spring.implementations;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * TODO: move to integration tests
 *
 * @author: Paweł Hulek
 * @created: 2017-01-18.
 */
class GetIntegrationTest {

    @Test
    public void should_get_google_web_page() {
        Optional<String> response = new Get<>(UrlTemplateBuilder.of().host("www.google.pl").build(),
                new RestTemplate(),
                String.class).send(Collections.emptyMap());
        assertThat(response).isPresent();
    }

    @Test
    public void should_not_found_page() {
        Get request = new Get<>(UrlTemplateBuilder.of().host("www.google.pl/ssd").build(),
                new RestTemplate(),
                String.class);
        assertThatThrownBy(() -> request.send(Collections.emptyMap())).isInstanceOf(HttpClientErrorException.class);
    }
}