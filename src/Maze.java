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
        solution.add(endingPoint);

        String currentPoint = "(0,0)";
        int currentRow = 0;
        int currentColumn = 0;
        int previousRow = -999;
        int previousColumn = -999;
        while (!currentPoint.equals(endingPoint)) {
            if (canMoveUp(currentPoint)) {
                if (previousRow != currentRow - 1) {
                    currentRow -= 1;
                    previousRow += 1;
                }
            }
            if (canMoveDown(currentPoint)) {
                if (previousRow != currentRow + 1) {
                    currentRow += 1;
                    previousRow -= 1;
                }
            }
            if (canMoveLeft(currentPoint)) {
                if (previousColumn != currentColumn - 1) {
                    currentColumn -= 1;
                    previousColumn += 1;
                }
            }
            if (canMoveRight(currentPoint)) {
                if (previousColumn != currentColumn + 1) {
                    currentColumn += 1;
                    previousColumn -= 1;
                }
            }

            currentPoint = "(" + currentRow + "," + currentColumn + ")";
            solution.add(solution.size() - 1, currentPoint);
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
        return maze[row - 1][column].equals(".");
    }

    private boolean canMoveDown(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));
        return maze[row + 1][column].equals(".");
    }

    private boolean canMoveLeft(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));
        return maze[row][column - 1].equals(".");
    }

    private boolean canMoveRight(String currentPoint) {
        int row = pointRow(currentPoint);
        int column = pointColumn((currentPoint));
        return maze[row][column + 1].equals(".");
    }
}
