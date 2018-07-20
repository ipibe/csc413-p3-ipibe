package TankGame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


/**
 * Created by Hector on 7/18/18.
 */
public class tank extends Canvas implements Runnable {
    /**
     *
     */

    private static final long serialVersion= 1L;
    private  boolean isRunning = false;
    private Thread thread;
    private Control control;
    private Camera camera;


    private BufferedImage level = null;



    public tank(){
        new window(1000,563,"TANKS",this);
        start();

        control =new Control();
        camera = new Camera(0,0);

        this.addKeyListener(new KeyInput(control));

        BufferedImageLoader img = new BufferedImageLoader();
        level = img.loadImage("/../background.png");

        LoadBG(level);


        }

    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }
    private void stop(){
        isRunning= false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta --;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {

        for(int i = 0; i <control.object.size(); i++){
            if(control.object.get(i).getId() ==ID.Player1){
                camera.tick(control.object.get(i));
            }
        }
        //get updated 60 times a sec
        control.tick();
    }
    public void render(){
        // gets updated 10000 times a sec
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            //pre-loads frames behind the window

            return;

        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;

        //able to draw on the panel

        g2.translate(camera.getX(),camera.getY());

        g.setColor(Color.lightGray);

        g.fillRect(0,0,1000,563);

       control.render(g); // checks this second

        g.dispose();
        bs.show();



    }

    // background

    private void LoadBG(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        for(int xx = 0; xx < w; xx++){
            for (int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(red == 255)
                    control.addObject((new Wall(xx*32,yy*32,ID.Wall)));
                if (blue == 255)
                    control.addObject(new Player(xx*32,yy*32, ID.Player1, control));

            }
        }
    }


    public static void main(String[] args) {
        new tank();



    }


}

