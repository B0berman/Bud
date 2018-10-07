package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class Test {
    public void draw(GL2 gl, GLUT glut) {
        glut.glutSolidSphere(1.0f, 20, 20);
    }
}
