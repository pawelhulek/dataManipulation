package prv.hulek.data.manipulation.web.requests.spring.implementations;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit
.jupiter.api.extension.ExtendWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestOperations;
import prv.hulek.data.manipulation.web.url.chain.builders.UrlTemplateBuilder;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by Paweł Hulek on 28.06.17.
 */

class DeleteTest {
    private RestOperations restOperations;
    private static final String FULL_API_ADDRESS = "www.website.pl/";

    @BeforeEach
    public void setUp(){
        restOperations = mock(RestOperations.class);
    }
    @Test
    public void should_delete_resource(){
        Delete deleteOperation =Delete.builder()
                .restOperations(restOperations)
                .url(UrlTemplateBuilder.of()
                        .host(FULL_API_ADDRESS)
                        .build())
                .build();
        assertThat(deleteOperation.send()).isEmpty();
        verify(restOperations).delete("http://www.website.pl/");
    }

}