package DAO;

import addon.AddOn;

import java.io.File;
import java.util.ArrayList;

public class AddOnDAO implements DAO<ArrayList<AddOn>, File> {
    @Override
    public File write(ArrayList<AddOn> bean) {
        return null;
    }

    @Override
    public ArrayList<AddOn> read(File folder) {
        ArrayList<AddOn> addOns = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            AddOn ao = new AddOn(fileEntry.getPath());
            try {
                ao.explore();
                addOns.add(ao);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return addOns;
    }
}
