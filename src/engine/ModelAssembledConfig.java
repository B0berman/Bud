package engine;

import Utils.Vector3;

public class ModelAssembledConfig {
    protected String    drawableId;
    protected Vector3   position;
    protected Vector3   rotation;
    protected Vector3   scale;

    public ModelAssembledConfig() {
    }

    public void setDrawableId(String drawableId) {
        this.drawableId = drawableId;
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

    public String getDrawableId() {
        return drawableId;
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
