package addon;

import DAO.FileDao;
import DAO.JsonDAO;

import java.util.ArrayList;

public class AddOn {

    private static String       DPENDENCY = "/dependencies.json";
    private static String       IDENTITY = "/identity.json";
    private static String       PROPERTY = "/properties.json";


    protected IdentityConfig    identity;
    protected DependencyConfig  dependencies;
    protected PropertiesConfig  properties;
    protected String            aoPath;

    public AddOn(String path) {
        aoPath = path;
    }

    private void loadIdentity(String path) throws Exception {
        FileDao fd = new FileDao(path);
        JsonDAO<IdentityConfig> jd = new JsonDAO<>(IdentityConfig.class);
        identity = jd.read(fd.read(null));
        if (identity == null)
            throw new Exception("Problem reading identity.json");
    }

    private void loadProperties(String path) throws Exception {
        FileDao fd = new FileDao(path);
        JsonDAO<PropertiesConfig> jd = new JsonDAO<>(PropertiesConfig.class);
        properties = jd.read(fd.read(null));
        if (properties == null)
            throw new Exception("Problem reading properties.json");
    }

    private void loadDependencies(String path) throws Exception {
        FileDao fd = new FileDao(path);
        JsonDAO<DependencyConfig> jd = new JsonDAO<>(DependencyConfig.class);
        dependencies = jd.read(fd.read(null));
        if (dependencies.getDependencies() == null)
            throw new Exception("Problem reading dependencies.json");
        // set variables
    }

    public void explore() throws Exception {
        loadIdentity(aoPath + IDENTITY);
        loadDependencies(aoPath + DPENDENCY);
        loadProperties(aoPath + PROPERTY);
    }

    public String getAoPath() {
        return aoPath;
    }

    public IdentityConfig getIdentity() {
        return identity;
    }

    public ArrayList<String> getDependencies() {
        return dependencies.getDependencies();
    }
}
