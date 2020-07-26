public class MazeRunner {
    static Maze maze = new Maze();

    public static void main (String[] args) {
        MazeRunner mazeRunner = new MazeRunner();
        maze.intializeMap();
        maze.printMap();
        mazeRunner.run();
    }

    public void run(){
        maze.start();
        maze.printMap();
        if (!(maze.finished())) {
            run();
        }
    }
}
