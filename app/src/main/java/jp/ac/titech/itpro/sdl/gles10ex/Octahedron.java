package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements SimpleRenderer.Obj {

    private FloatBuffer vbuf;
    private float x, y, z;

    public Octahedron(float s, float x, float y, float z) {
        float[] vertices = {
                //
                s, 0, 0,
                0, s, 0,
                0, 0, s,
                //
                -s, 0, 0,
                0, s, 0,
                0, 0, s,
                //
                s, 0, 0,
                0, s, 0,
                0, 0, -s,
                //
                -s, 0, 0,
                0, s, 0,
                0, 0, -s,
                //
                s, 0, 0,
                0, -s, 0,
                0, 0, s,
                //
                -s, 0, 0,
                0, -s, 0,
                0, 0, s,
                //
                s, 0, 0,
                0, -s, 0,
                0, 0, -s,
                //
                -s, 0, 0,
                0, -s, 0,
                0, 0, -s
        };
        vbuf = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        //
        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);

        //
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 3, 3);

        //
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 6, 3);

        //
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 9, 3);

        //
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 3);

        //
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 15, 3);

        //
        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 18, 3);

        //
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 21, 3);
    }
    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}
