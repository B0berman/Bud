package addon;

import java.util.ArrayList;

public class DependencyConfig {

    protected ArrayList<AddOn>  dependencies;

    public DependencyConfig() {
    }

    public ArrayList<AddOn> getDependencies() {
        return dependencies;
    }

    public boolean addDependency(AddOn ao) {
        dependencies.add(ao);
        return true;
    }


}
