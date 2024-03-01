

public class Pipes {

    public class Pipe {
        private int height = 0;
        private int width = 0;

        public Pipe (int height, int width) {
            this.height = height;
            this.width = width;
        };
    }

    private int positionX = 0;

    private Pipe Top = null;
    private Pipe Bottom = null;

    public Pipes (int height, int width, int positionX) {

        this.positionX = positionX;

        this.Top = new Pipe ( (int)(Math.random() * height - 159), width);
        this.Bottom = new Pipe (height - Top.height, width);
    }    
}
