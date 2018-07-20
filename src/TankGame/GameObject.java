package TankGame;

import java.awt.*;

/**
 * Created by Hector on 7/18/18.
 */
public abstract class GameObject {
    protected  int x,y;
    protected float velX = 0, velY = 0;
    //velocity of object
    protected ID id;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }



    public abstract void tick();
    // updates
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    //detects collision for every object


    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
}
