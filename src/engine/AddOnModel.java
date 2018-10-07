package engine;

import DAO.FileDao;
import DAO.JsonDAO;
import addon.AddOn;

public class AddOnModel {

    protected ModelConfig   configuration;
    protected AddOn         addOn;

    public void loadModel() {
        FileDao fd = new FileDao(addOn.getAoPath() + "/model.json");
        JsonDAO<ModelConfig> jd = new JsonDAO<>(ModelConfig.class);
        configuration = jd.read(fd.read(null));
    }

    public AddOnModel(AddOn addOn) {
        this.addOn = addOn;
    }

    public ModelConfig getConfiguration() {
        return configuration;
    }

    public AddOn getAddOn() {
        return addOn;
    }
}
