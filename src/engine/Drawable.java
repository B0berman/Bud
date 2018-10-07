package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public interface Drawable {
    void draw(GL2 gl, GLUT glut);
}
