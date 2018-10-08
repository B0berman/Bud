import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Utils.Vector3;
import addon.AddOn;
import addon.AddOnManager;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import engine.AddOnLoader;
import engine.Drawable;
import engine.ResourceManager;

public class MainFrame extends JFrame implements GLEventListener{

    public MainFrame(){
        setTitle("Lit Sphere Demo, with JOGL");
        setSize(640, 480);

        GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());
        GLCanvas glCanvas = new GLCanvas(glCapabilities);
        glCanvas.addGLEventListener(this);
        add(glCanvas);

        final FPSAnimator animator = new FPSAnimator(glCanvas, 60);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }

        });

        animator.start();
    }

    private static final long serialVersionUID = -1227038124975588633L;

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.8f, 0.5f, 0.0f, 1.0f);

        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glClearDepth(1.0f);

        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glEnable(GL2.GL_LIGHTING);

        gl.glEnable(GL2.GL_LIGHT0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, light_0_ambient, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, light_0_diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, light_0_specular, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light_0_position, 0);

        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glColorMaterial(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE);
        gl.glMateriali(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 90);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, material_specular, 0);

        AddOnManager am = new AddOnManager();
        am.exploreAddOns();
        am.setResourceManager(resourceManager);
        am.loadAddons();


        Entity test1 = new Entity();
        test1.addDrawable(resourceManager.getDrawable("2"));
        test1.setPosition(new Vector3(0, 0, 0));
        test1.setRotation(new Vector3(0, 0, 0));
        test1.setScale(new Vector3(0, 0, 0));

        Entity test2 = new Entity();
        test2.addDrawable(resourceManager.getDrawable("1"));
        test2.setPosition(new Vector3(3, 0, 0));
        test2.setRotation(new Vector3(0, 0, 0));
        test2.setScale(new Vector3(0, 0, 0));

        map.addEntity(test1);
        map.addEntity(test2);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable GlDrawable) {
        GL2 gl = GlDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        glu.gluLookAt(
                camera[0], camera[1], camera[2],
                0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f
        );

        gl.glRotatef(angle, 0f, 1f, 0f);

        gl.glColor3f(1.0f, 0.0f, 0.0f);
        //glut.glutSolidSphere(1.0f, 20, 20);

        for (Entity entity : map.getEntitys()) {
            gl.glTranslatef(entity.getPosition().x(), entity.getPosition().y(), entity.getPosition().z());
            for (Drawable drawable : entity.getDrawables()) {
                drawable.draw(gl, glut);
            }
            gl.glTranslatef(-entity.getPosition().x(), -entity.getPosition().y(), -entity.getPosition().z());
        }

        angle += 0.1f;
        angle %= 360f;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(x, y, width, height);

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60.0f, (float) width/height, 0.1f, 10.0f);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    private GLU glu = new GLU();
    private GLUT glut = new GLUT();

    private Map map = new Map();
    ResourceManager resourceManager = new ResourceManager();

    private float camera [] = {0f, 0f, 5f};

    private float [] light_0_ambient = {0.01f, 0.01f, 0.01f, 0.01f};
    private float [] light_0_diffuse = {1.0f, 1.0f, 1.0f, 1.0f};
    private float [] light_0_specular = {1.0f,1.0f, 1.0f, 1.0f};
    private float [] light_0_position = {100f, 0f, 10f, 1f};

    private float [] material_specular = {1.0f, 1.0f, 1.0f, 1.0f};

    private float angle = 0f;

}