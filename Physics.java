public class Physics implements Runnable {

    private static Pipes[] Obstacles = App.getObstacles();

    private static int blockY = 360;
    private static boolean blockDirection = true; //up == true down == false

    public static int getBlockY() {
        return blockY; 
    }

    public static void terminate() {
        return;
    }

    public static void setBlockDirection (boolean direction) {
        blockDirection = direction;
    }

    public static void updateObstacles() {
        for (int i = 0; i < 10; ++i ) {
            Obstacles[i].setPositionX(Obstacles[i].getPositionX() - 8);

            if (Obstacles[i].getPositionX() + 80 < 0) App.setNewPipes(i);
        }

        //reposition block based on direction:
        if (blockDirection == true) {//upwards:
            blockY -= 12;

            if (blockY < 0) {blockY += 12; blockDirection = false;}

        } else {
            blockY += 12; //downwards

            if (blockY > GUI.getScreenSize()[1] - 80) {blockY -= 12; blockDirection = true;}
        }
        
        GUI.removeObstacles();
        GUI.draw();
    }
    
    public static void collisionCheck() {

    }

    public void run() {

    }
}