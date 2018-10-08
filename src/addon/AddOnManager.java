package addon;

import DAO.AddOnDAO;
import engine.AddOnLoader;
import engine.ResourceManager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddOnManager {

    private static String       ROOT = "./resources/AddOns";

    AddOnLoader addOnLoader = new AddOnLoader();
    protected ResourceManager       resourceManager;
    protected Map<String, AddOn>    addOns = new HashMap<String, AddOn>();

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
        AddOnDAO addOnDAO = new AddOnDAO();
        ArrayList<AddOn> addOnList = addOnDAO.read(new File(ROOT));
        for (AddOn addOn: addOnList) {
            addOns.put(addOn.getIdentity().getId(), addOn);
        }
    }

    public void loadAddOnDependencies(ArrayList<String> result, AddOn addOn) {
        for (String dependency : addOn.getDependencies()) {
            loadAddOnDependencies(result, addOns.get(dependency));
        }
        if (!result.contains(addOn.getIdentity().getId())) {
            addOnLoader.loadAddOn(addOns.get(addOn.getIdentity().getId()), resourceManager);
            result.add(addOn.getIdentity().getId());
        }
    }

    public void loadAddons() {
        ArrayList<String> result = new ArrayList<>();
        for (AddOn addOn : addOns.values()) {
            loadAddOnDependencies(result, addOn);
        }
    }

    public void setResourceManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }
}
