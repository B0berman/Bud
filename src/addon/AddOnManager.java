package addon;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AddOnManager {

    private static String       ROOT = "./resources/AddOns";

    protected Map<String, AddOn> addOns = new HashMap<String, AddOn>();

    public AddOnManager() {
        // get files from root
    }

    public void addDependency(AddOn ao) {
        addOns.put(ao.getIdentity().getId(), ao);
    }

    public Map<String, AddOn> getAddOns() {
        return addOns;
    }

    public AddOn getAddOn(String id) {
        return addOns.get(id);
    }

    public void exploreAddOns() {
        File folder = new File(ROOT);
        for (final File fileEntry : folder.listFiles()) {
            AddOn ao = new AddOn(fileEntry.getPath());
            try {
                ao.explore();
                addOns.put(ao.getIdentity().getId(), ao);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
