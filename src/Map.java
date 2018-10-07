import java.util.ArrayList;

public class Map {
    ArrayList<Entity> entitys;

    public Map() {
        entitys = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entitys.add(entity);
    }

    public void removeEntity(Entity entity) {
        entitys.remove(entity);
    }

    public ArrayList<Entity> getEntitys() {
        return entitys;
    }
}
