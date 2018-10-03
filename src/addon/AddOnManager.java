package addon;

import java.util.ArrayList;

public class AddOnManager {

    private static String       ROOT = "/addons/";

    protected ArrayList<AddOn>  addOns;

    public AddOnManager() {
        // get files from root
    }

    public boolean addDependency(AddOn ao) {
        return addOns.add(ao);
    }

    public ArrayList<AddOn> getAddOns() {
        return addOns;
    }

    public void exploreAddOns() {
        // read ROOT directory to generates addons
        ArrayList<AddOn> addons = null;
        for (AddOn ao : addOns) {
            try {
                ao.explore();
            } catch (Exception e) {
            }
        }
    }

    public void loadAddOns() {
        for (AddOn ao : addOns) {
            ao.load();
        }
    }
}
