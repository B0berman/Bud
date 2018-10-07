package engine;

import Utils.Vector3;

public class ModelAssembled {

    protected Drawable drawable;
    protected Vector3 position;
    protected Vector3 rotation;
    protected Vector3 scale;

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public void setRotation(Vector3 rotation) {
        this.rotation = rotation;
    }

    public void setScale(Vector3 scale) {
        this.scale = scale;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getRotation() {
        return rotation;
    }

    public Vector3 getScale() {
        return scale;
    }
}
