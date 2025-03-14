import java.util.ArrayList;

public class Maze {
    private String[][] maze;

    public Maze(String[][] maze) {
        this.maze = maze;
    }

    public String toString() {
        String str = "";
        for (String[] row : maze) {
            for (String column : row) {
                str += column + " ";
            }
            str += "\n";
        }
        return str;
    }

    public ArrayList<String> part1() {
        ArrayList<String> solution = new ArrayList<String>();
        solution.add("(0,0)");
        String endingPoint = "(" + (maze.length - 1) + "," + (maze[0].length - 1) + ")";

        String currentPoint = "(0,0)";
        int currentRow = 0;
        int currentColumn = 0;
        while (!currentPoint.equals(endingPoint)) {
            maze[currentRow][currentColumn] = "#";
            if (canMoveUp(currentPoint)) {
                    currentRow -= 1;
            }
            if (canMoveDown(currentPoint)) {
                    currentRow += 1;
            }
            if (canMoveLeft(currentPoint)) {
                    currentColumn -= 1;
            }
            if (canMoveRight(currentPoint)) {
                    currentColumn += 1;
            }

            currentPoint = "(" + currentRow + "," + currentColumn + ")";
            solution.add( currentPoint);
        }


        return solution;
    }

    public ArrayList<String> part2() {
        ArrayList<String> solution = new ArrayList<String>();
        solution.add("(0,0)");
        String endingPoint = "(" + (maze.length - 1) + "," + (maze[0].length - 1) + ")";
        ArrayList<String> forkPoints = new ArrayList<String>();

        String currentPoint = "(0,0)";
        int currentRow = 0;
        int currentColumn = 0;
        while (!currentPoint.equals(endingPoint)) {

            maze[currentRow][currentColumn] = "#";

            if (canMoveUp(currentPoint)) {
                currentRow -= 1;
            }
            if (canMoveDown(currentPoint)) {
                currentRow += 1;
            }
            if (canMoveLeft(currentPoint)) {
                currentColumn -= 1;
            }
            if (canMoveRight(currentPoint)) {
                currentColumn += 1;
            }

            currentPoint = "(" + currentRow + "," + currentColumn + ")";
            solution.add( currentPoint);
        }


        return solution;
    }

    private int pointRow(String point) {
        int row = Integer.parseInt(point.substring(1, point.indexOf(",")));
        return row;
    }

    private int pointColumn(String point) {
        int column = Integer.parseInt(point.substring(point.indexOf(",") + 1, point.indexOf(")")));
        return column;
    }

    private boolean canMoveUp(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));

        if (row != 0) {
            return maze[row - 1][column].equals(".");
        }
        return false;
    }

    private boolean canMoveDown(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));

        if (row != maze.length - 1) {
            return maze[row + 1][column].equals(".");
        }
        return false;
    }

    private boolean canMoveLeft(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));

        if (column != 0) {
            return maze[row][column - 1].equals(".");
        }
        return false;
    }

    private boolean canMoveRight(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));

        if (column != maze[row].length - 1) {
            return maze[row][column + 1].equals(".");
        }
        return false;
    }
}
