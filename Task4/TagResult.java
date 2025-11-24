import java.io.Serializable;
import java.util.Map;

public class TagResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> tags;

    public TagResult(Map<String, Integer> tags) {
        this.tags = tags;
    }

    public Map<String, Integer> getTags() {
        return tags;
    }
}
