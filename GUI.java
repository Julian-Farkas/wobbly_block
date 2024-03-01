import javax.swing.*;
import java.awt.Color;

public class GUI implements Runnable{
    
    private static int[] screenSize = {0, 0};

    public static void setScreenSize (int width, int height) {
        screenSize[0] = width;
        screenSize[1] = height;
    }
    public static int[] getScreenSize() {
        return screenSize;
    }

    public void run() {

        JFrame RootFrame = new JFrame("Wobbly Block");
        RootFrame.setLayout(null);
        RootFrame.setSize(screenSize[0], screenSize[1]);
        RootFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //later replace with window listener!

        JPanel Block = new JPanel();
        Block.setBackground(Color.RED);
        Block.setBounds(0, screenSize[1]/2 - 80, 80, 80);

        JPanel[] ObsTop = new JPanel[10];
        JPanel[] ObsBottom = new JPanel[10];
        Pipes[] Obs = App.getObstacles();

        

        //draw initial obstacles:
        for (int i = 0; i < 10; ++i) {

            ObsTop[i] = new JPanel();
            ObsBottom[i] = new JPanel();

            ObsTop[i].setBounds( Obs[i].getPositionX(), 0, Obs[i].getTop().getW(), Obs[i].getTop().getH() );
            ObsBottom[i].setBounds( Obs[i].getPositionX(), Obs[i].getBottomY(), Obs[i].getBottom().getW(), Obs[i].getBottom().getH() );

            ObsTop[i].setBackground(Color.LIGHT_GRAY);
            ObsBottom[i].setBackground(Color.LIGHT_GRAY);

            RootFrame.add(ObsTop[i]);
            RootFrame.add(ObsBottom[i]);

        }
        
        RootFrame.add(Block);
        RootFrame.setVisible(true);
    }
}