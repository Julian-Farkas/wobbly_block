

public class App {

    private static Pipes[] Obstacles = new Pipes[10];

    public static Pipes[] getObstacles() {
        return Obstacles;
    }

    public static void main(String[] args) {
        
        Thread Gui = new Thread( new GUI());

        GUI.setScreenSize(1280, 720);

        //create initial obstacle pipes:
        Obstacles[0] = new Pipes(720, 80, 400);

        for (int i = 1; i < 10; ++i) {
            Obstacles[i] = new Pipes(720, 80, Obstacles[i-1].getPositionX() + 400);
        }
        
        Gui.start();
        
        while (Gui.isAlive())
        {
            int i = 1 + 1;
        }

        return;
    }
}