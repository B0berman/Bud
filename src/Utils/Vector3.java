package Utils;

public class Vector3 extends Speaker<Vector3Listener> {
    protected float[] values = {0, 0, 0};

    public Vector3() {

    }

    public Vector3(float x, float y, float z) {
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }

    public float x() {
        return values[0];
    }

    public float y() {
        return values[1];
    }

    public float z() {
        return values[2];

    }

    public void setX(float x) {
        values[0] = x;
        notifyListener();
    }

    public void setY(float y) {
        values[1] = y;
        notifyListener();
    }

    public void setZ(float z) {
        values[2] = z;
        notifyListener();
    }

    public void setValues(float x, float y, float z) {
        values[0] = x;
        values[1] = y;
        values[2] = z;
        notifyListener();
    }

    public void setValues(float[] values) {
        this.values[0] = values[0];
        this.values[1] = values[1];
        this.values[2] = values[2];
        notifyListener();
    }

    private void notifyListener() {
        for (Vector3Listener listener : listeners) {
            listener.onChange(this);
        }
    }
}
