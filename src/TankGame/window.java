package TankGame;

import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Created by Hector on 7/18/18.
 */
public class window {

    public window(int width, int height, String title, tank tanque){

        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.add(tanque);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
