import Utils.Vector3;
import engine.Drawable;

import java.util.ArrayList;

public class Entity {
    protected int id;
    protected ArrayList<Drawable> drawables = new ArrayList<>();
    protected Vector3 position = null;
    protected Vector3 rotation = null;
    protected Vector3 scale = null;


    public Entity() {
        id = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Drawable> getDrawables() {
        return drawables;
    }

    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    public void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getRotation() {
        return rotation;
    }

    public void setRotation(Vector3 rotation) {
        this.rotation = rotation;
    }

    public Vector3 getScale() {
        return scale;
    }

    public void setScale(Vector3 scale) {
        this.scale = scale;
    }
}
