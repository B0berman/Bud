package engine;

import addon.AddOn;

public class AddOnLoader {

    protected ResourceManager   resourceManager;

    public AddOnLoader(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    void loadModel(AddOnModel addOnModel) {
        addOnModel.loadModel();
        Model model = new Model(addOnModel.getConfiguration());
        resourceManager.addDrawable(addOnModel.getAddOn().getIdentity().getId(), model);
    }

    void loadModelAssembly(AddOnModelAssembly addOnModelAssembly) {
        addOnModelAssembly.loadModelAssembly();
        ModelAssembly modelAssembly = new ModelAssembly();
        for (ModelAssembledConfig modelAssembledConfig : addOnModelAssembly.getConfiguration().getChildren()) {
            ModelAssembled modelAssembled = new ModelAssembled();
            modelAssembled.setPosition(modelAssembledConfig.getPosition());
            modelAssembled.setRotation(modelAssembledConfig.getRotation());
            modelAssembled.setScale(modelAssembledConfig.getScale());
            String id = modelAssembledConfig.getDrawableId();
            Drawable drawable = resourceManager.getDrawable(id);
            modelAssembled.setDrawable(drawable);
            modelAssembly.addChild(modelAssembled);
        }
        resourceManager.addDrawable(addOnModelAssembly.getAddOn().getIdentity().getId(), modelAssembly);
    }

    public void loadAddOn(AddOn addOn) {
        switch (addOn.getIdentity().getContentType()) {
            case MODEL:
                AddOnModel addOnModel = new AddOnModel(addOn);
                loadModel(addOnModel);
                break;
            case MODEL_ASSEMBLY:
                AddOnModelAssembly addOnModelAssembly = new AddOnModelAssembly(addOn);
                loadModelAssembly(addOnModelAssembly);
                break;
        }
    }
}
