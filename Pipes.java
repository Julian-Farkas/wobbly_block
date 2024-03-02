

public class Pipes {

    public class Pipe {
        private int height = 0;
        private int width = 0;

        public Pipe (int height, int width) {
            this.height = height;
            this.width = width;
        }

        public int getW() {
            return this.width;
        }

        public int getH() {
            return this.height;
        }
    }

    private int positionX = 0;

    private Pipe Top = null;
    private Pipe Bottom = null;

    private int bottomY = 0;

    public Pipes (int height, int width, int positionX) {

        this.positionX = positionX;

        this.Top = new Pipe ( (int) (Math.random() * (height - 159) ), width);
        this.Bottom = new Pipe (height - Top.height, width);

        this.bottomY = this.Top.getH() + 240;
    }
    
    public Pipe getTop() {
        return this.Top;
    }

    public Pipe getBottom() {
        return this.Bottom;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int newPositionX) {
        this.positionX = newPositionX;
    }


    public int getBottomY() {
        return this.bottomY;
    }
}
