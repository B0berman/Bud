package engine;

import DAO.FileDao;
import DAO.JsonDAO;
import addon.AddOn;

public class AddOnModelAssembly {
    protected ModelAssemblyConfig   configuration;
    protected AddOn                 addOn;

    public AddOnModelAssembly(AddOn addOn) {
        this.addOn = addOn;
    }

    public void loadModelAssembly() {
        FileDao fd = new FileDao(addOn.getAoPath() + "/model_assembly.json");
        JsonDAO<ModelAssemblyConfig> jd = new JsonDAO<>(ModelAssemblyConfig.class);
        configuration = jd.read(fd.read(null));
    }

    public ModelAssemblyConfig getConfiguration() {
        return configuration;
    }

    public AddOn getAddOn() {
        return addOn;
    }
}
