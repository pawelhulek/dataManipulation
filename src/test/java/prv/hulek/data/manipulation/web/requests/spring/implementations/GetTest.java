package prv.hulek.data.manipulation.web.requests.spring.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-18.
 */
class GetTest {

    private static final String VALID_RESPONSE = "validResponse";
    private static final String API_ADDRESS = "www.website.pl";
    private static final String FULL_API_ADDRESS = "http://www.website.pl/";
    private RestTemplate REST_OPERATIONS;

    @BeforeEach
    public void setUp() {
        REST_OPERATIONS = mock(RestTemplate.class);
    }

    @Test
    public void should_get_data() {
        given(REST_OPERATIONS.getForObject(eq(FULL_API_ADDRESS), any())).willReturn(VALID_RESPONSE);
        Optional<String> response = new Get<>(UrlTemplateBuilder.of().host(API_ADDRESS).build(),
                REST_OPERATIONS,
                String.class).send(Collections.emptyMap());
        assertThat(response).isPresent().hasValue(VALID_RESPONSE);
    }

    @Test
    public void should_not_found_any_data() {
        given(REST_OPERATIONS.getForObject(eq(FULL_API_ADDRESS), any())).willThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND, "No data found"));
        Get<String> request = new Get<>(UrlTemplateBuilder.of().host(API_ADDRESS).build(),
                REST_OPERATIONS,
                String.class);
        assertThatThrownBy(() -> request.send(Collections.emptyMap())).isInstanceOf(HttpClientErrorException.class);
    }

    @Test
    public void should_found_empty_data() {
        given(REST_OPERATIONS.getForObject(eq(FULL_API_ADDRESS), any())).willReturn(null);
        Get<String> request = new Get<>(UrlTemplateBuilder.of().host(API_ADDRESS).build(),
                REST_OPERATIONS,
                String.class);
        assertThat(request.send(Collections.emptyMap())).isNotPresent();
    }
}