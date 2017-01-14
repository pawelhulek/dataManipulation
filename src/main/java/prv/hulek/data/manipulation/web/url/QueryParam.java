package prv.hulek.data.manipulation.web.url;

import prv.hulek.data.manipulation.web.url.exceptions.MissingValueException;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
public class QueryParam extends Parameter {

    private static final String QUERY_START_STRING = "${";
    private static final String QUERY_END_STRING = "}";

    public QueryParam(String name) {
        super(name);
    }

    @Override
    public String toUrlSegment() {
        if (getValue() == null)
            throw new MissingValueException(String.format("Value %s is missing", getName()));
        return PathSegment.endsOnSlash(encodeSpecialValues(this.getValue()));
    }
}
