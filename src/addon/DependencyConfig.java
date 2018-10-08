package addon;

import java.util.ArrayList;

public class DependencyConfig {

    protected ArrayList<String>  dependencies;

    public DependencyConfig() {
    }

    public ArrayList<String> getDependencies() {
        return dependencies;
    }

    public boolean addDependency(String ao) {
        dependencies.add(ao);
        return true;
    }


}
