public class Physics implements Runnable {

    private static Pipes[] Obstacles = App.getObstacles();
    private static int current = 0;
    private static int score = 0;

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
    
    public static void collisionCheck() { //blockXOffset = 160
        //check whether block already passed or is still in collision range:

        if ( 160 /*BlockXOffset+width*/ > Obstacles[current].getPositionX() + Obstacles[current].getTop().getW()) {
            //go to next pipes:
            ++current;
            // loop back to 1st position in array:
            if (current > 9) current = 0;
            //increment score if passed:
            ++score;
        }

        //check if block collides on x-axis:
        if ( Obstacles[current].getPositionX() < 240 ) {

            //check the y-axis of top pipe:
            if (Obstacles[current].getTop().getH() > blockY) {
                restart();
            //check the y-axis of bottom pipe:
            } else if ( Obstacles[current].getBottomY() < blockY + 80) {
                restart();
            }
        } 
    }

    public static void restart() {
        current = 0;
        App.createObstacles();
        GUI.removeObstacles();
        GUI.draw();
    }

    public void run() {

    }
}