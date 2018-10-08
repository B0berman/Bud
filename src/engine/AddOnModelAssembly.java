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

    public void loadModelAssembly() throws Exception {
        FileDao fd = new FileDao(addOn.getAoPath() + "/model_assembly.json");
        JsonDAO<ModelAssemblyConfig> jd = new JsonDAO<>(ModelAssemblyConfig.class);
        configuration = jd.read(fd.read(null));
        if (configuration == null || configuration.getChildren().get(configuration.getChildren().size() - 1) == null)
            throw new Exception("Problem reading configuration file : " + addOn.getAoPath() + "/model_assembly.json");
    }

    public ModelAssemblyConfig getConfiguration() {
        return configuration;
    }

    public AddOn getAddOn() {
        return addOn;
    }
}
