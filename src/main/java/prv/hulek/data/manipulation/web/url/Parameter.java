package prv.hulek.data.manipulation.web.url;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class Parameter implements PathSegment {

    private final static Map<String, String> SPECIAL_SIGN_TRANSFORMATION = ImmutableMap.<String, String>builder().put(" ", "%20").build();
    private final String name;
    private String value;
    private boolean isFirst;

    protected String encodeSpecialValues(String value) {
        return Arrays.stream(value.split("")).reduce("", (s, s2) -> s + transformToSpecialCharacter(s2));
    }

    private String transformToSpecialCharacter(String value) {
        if (SPECIAL_SIGN_TRANSFORMATION.containsKey(value))
            return SPECIAL_SIGN_TRANSFORMATION.get(value);
        else
            return value;
    }
}