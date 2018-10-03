package addon;

public class IdentityConfig {

    public enum AO_TYPE {
        MODEL
    }

    protected String    id;
    protected AO_TYPE   type;
    protected String    name;
    protected String    description;
    protected float     version; // class to define

    public IdentityConfig() {
    }

    public String getId() {
        return id;
    }

    public AO_TYPE getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getVersion() {
        return version;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(AO_TYPE type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void update() {
        this.version = version + 0.01f;
    }
}
