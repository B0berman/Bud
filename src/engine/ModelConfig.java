package engine;

public class ModelConfig {
    protected float     r;
    protected int       aVertical;
    protected int       aHorizontal;

    public ModelConfig() {
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setaVertical(int aVertical) {
        this.aVertical = aVertical;
    }

    public void setaHorizontal(int aHorizontal) {
        this.aHorizontal = aHorizontal;
    }

    public float getR() {
        return r;
    }

    public int getaVertical() {
        return aVertical;
    }

    public int getaHorizontal() {
        return aHorizontal;
    }
}
