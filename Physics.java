public class Physics implements Runnable {

    private static Pipes[] Obstacles = App.getObstacles();

    public static void updateObstacles() {
        for (int i = 0; i < 10; ++i ) {
            Obstacles[i].setPositionX(Obstacles[i].getPositionX() - 8);

            if (Obstacles[i].getPositionX() + 80 < 0) App.setNewPipes(i);
        }

        GUI.removeObstacles();
        GUI.draw();
    }
    
    public static void collisionCheck() {

    }

    public void run() {

    }
}