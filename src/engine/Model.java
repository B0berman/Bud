package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class Model implements Drawable {

    protected float     r;
    protected int       aVertical;
    protected int       aHorizontal;

    public Model(ModelConfig config) {
        r = config.getR();
        aVertical = config.getaVertical();
        aHorizontal = config.getaHorizontal();
    }

    @Override
    public void draw(GL2 gl, GLUT glut) {
        glut.glutSolidSphere(r, aHorizontal, aVertical);
    }
}
