

public class App {

    private static Pipes[] Obstacles = new Pipes[10];

    public static Pipes[] getObstacles() {
        return Obstacles;
    }

    public static void setNewPipes(int index) {

        int posX = 0;
        //if first element get positionX of last element in list:
        if (index > 0) {
            posX = Obstacles[index - 1].getPositionX();
        } else {
            posX = Obstacles[9].getPositionX();
        }

        Obstacles[index] = new Pipes(GUI.getScreenSize()[1], 80, posX + 400);
    }

    public static void createObstacles() {
        Obstacles[0] = new Pipes(720, 80, 600);
        for (int i = 1; i < 10; ++i) {
            Obstacles[i] = new Pipes(720, 80, Obstacles[i-1].getPositionX() + 400);
        }
    }

    public static void main(String[] args) {
        
        Thread Gui = new Thread( new GUI());
        Thread Physics = new Thread( new Physics());

        GUI.setScreenSize(1280, 720);

        //create initial obstacle pipes:
        

        createObstacles();

        Physics.start();
        Gui.start();

        return;
    }
}