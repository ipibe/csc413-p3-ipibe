package TankGame;

import java.awt.*;

/**
 * Created by Hector on 7/18/18.
 */
public class Player extends GameObject{

    Control control;


    public Player(int x, int y, ID id,Control control) {
        super(x, y, id);
        this.control = control;
    }

    @Override
    public void tick() {
        x+= velX;
        y+= velY;

        //movement

        if(control.isUp()) velY = -5;
        else if(!control.isDown()) velY = 0;


        if(control.isDown()) velY = 5;
        else if(!control.isUp()) velY = 0;


        if(control.isRight()) velX = 5;
        else if(!control.isLeft()) velX = 0;


        if(control.isLeft()) velX = -5;
        else if(!control.isRight()) velX = 0;



    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,32,32);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,48);
    }
}
