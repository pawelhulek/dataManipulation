package prv.hulek.data.manipulation.web.url;

/**
 * @author: Paweł Hulek
 * @created: 2017-01-12.
 */
public class RequestParam extends Parameter {

    public RequestParam(String name) {
        super(name);
    }

    @Override
    public String toUrlSegment() {
        if (getValue() == null) {
            return "";
        }
        return (isFirst() ? "?" : "&") + this.getName() + "=" + encodeSpecialValues(this.getValue());
    }
}
