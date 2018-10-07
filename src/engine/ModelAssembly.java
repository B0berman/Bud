package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

import java.util.ArrayList;

public class ModelAssembly implements Drawable {

    ArrayList<ModelAssembled> children = new ArrayList<>();

    public ModelAssembly() {

    }

    public void addChild(ModelAssembled modelAssembled) {
        children.add(modelAssembled);
    }

    public ArrayList<ModelAssembled> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ModelAssembled> children) {
        this.children = children;
    }

    @Override
    public void draw(GL2 gl, GLUT glut) {
        for (ModelAssembled modelAssembled : children) {
            gl.glTranslatef(modelAssembled.getPosition().x(), modelAssembled.getPosition().y(), modelAssembled.getPosition().z());

            modelAssembled.getDrawable().draw(gl, glut);

            gl.glTranslatef(-modelAssembled.getPosition().x(), -modelAssembled.getPosition().y(), -modelAssembled.getPosition().z());
        }
    }
}
