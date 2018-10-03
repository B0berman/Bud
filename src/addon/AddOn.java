package addon;

public class AddOn {

    private static String       DPENDENCY = "/dependency.json";
    private static String       IDENTITY = "/identity.json";


    protected IdentityConfig    identity;
    protected DependencyConfig  dependencies;
    protected String            aoPath;

    public AddOn(String path) {
        aoPath = path;
    }

    private IdentityConfig loadIdentity(String path) throws Exception {
        // read path directory
        IdentityConfig ic = new IdentityConfig();
        // set variables
        return ic;
    }

    private DependencyConfig loadDependencies(String path) throws Exception {
        // read path directory
        DependencyConfig dc = new DependencyConfig();
        // set variables
        return dc;
    }

    public void load() {

    }

    public void explore() throws Exception {
        identity = loadIdentity(aoPath + IDENTITY);
        dependencies = loadDependencies(aoPath + DPENDENCY);
    }

    public IdentityConfig getIdentity() {
        return identity;
    }

    public DependencyConfig getDependencies() {
        return dependencies;
    }
}
