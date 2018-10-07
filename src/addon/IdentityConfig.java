package addon;

public class IdentityConfig {

    public enum AO_CONTENT_TYPE {
        MODEL,
        MODEL_ASSEMBLY
    }

    protected String    id;
    protected AO_CONTENT_TYPE   contentType;
    protected String    name;
    protected String    description;
//    protected float     version; // class to define

    public IdentityConfig() {
    }

    public String getId() {
        return id;
    }

    public AO_CONTENT_TYPE getContentType() {
        return contentType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

/*    public float getVersion() {
        return version;
    }

    public void update() {
        this.version = version + 0.01f;
    }
*/
    public void setId(String id) {
        this.id = id;
    }

    public void setContentType(AO_CONTENT_TYPE type) {
        this.contentType = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
