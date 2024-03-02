import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class GUI implements Runnable, KeyListener{
    
    private static int[] screenSize = {0, 0};

    static Pipes[] Obs = App.getObstacles();

    private static JPanel[] ObsTop = new JPanel[10];
    private static JPanel[] ObsBottom = new JPanel[10];

    private static JPanel Block = new JPanel();

    public void keyPressed(KeyEvent ev) {

        if (ev.getKeyCode() == 83) { //A (down)
            Physics.setBlockDirection(false);

        } else if (ev.getKeyCode() == 87) {
            Physics.setBlockDirection(true);
        }
        
    }

    public void keyReleased(KeyEvent ev) {}
    public void keyTyped(KeyEvent ev) {}

    public static void removeObstacles() {
        RootFrame.getContentPane().removeAll();
    }

    public static void draw() {
        for (int i = 0; i < 10; ++i) {

            //create pipes and set bounds based on mAtH:
            ObsTop[i] = new JPanel();
            ObsBottom[i] = new JPanel();
            ObsTop[i].setBounds( Obs[i].getPositionX(), 0, Obs[i].getTop().getW(), Obs[i].getTop().getH() );
            ObsBottom[i].setBounds( Obs[i].getPositionX(), Obs[i].getBottomY(), Obs[i].getBottom().getW(), Obs[i].getBottom().getH() );
            
            ObsTop[i].setBackground(Color.LIGHT_GRAY);
            ObsBottom[i].setBackground(Color.LIGHT_GRAY);
            RootFrame.add(ObsTop[i]);
            RootFrame.add(ObsBottom[i]);

            //redraw block:
            Block.setBounds(160, Physics.getBlockY(), 80, 80);
            Block.setBackground(Color.RED);
            RootFrame.add(Block);

        }
    }

    public static void setScreenSize (int width, int height) {
        screenSize[0] = width;
        screenSize[1] = height;
    }
    public static int[] getScreenSize() {
        return screenSize;
    }

    private static JFrame RootFrame = new JFrame("Wobbly Block");
    public void run() {

        
        RootFrame.setLayout(null);
        RootFrame.setSize(screenSize[0], screenSize[1]);
        RootFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //later replace with window listener!

        //add listener to move block:
        RootFrame.addKeyListener(this);
        RootFrame.addWindowListener( new WindowAdapter () {
            public void windowClosing( WindowEvent ev) {
                Physics.terminate();
                RootFrame.dispose();
                System.exit(0); //should find better solution
            }
        });

        Block.setBackground(Color.RED);
        Block.setBounds(160, screenSize[1]/2 - 80, 80, 80);        

        //draw initial obstacles:
            draw();

            RootFrame.add(Block);
            RootFrame.setVisible(true);

            while(true) {
                try {
                    Thread.sleep(15);
                    Physics.updateObstacles();
                    Physics.collisionCheck();
                    RootFrame.repaint();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //}

        }
        
    }
}