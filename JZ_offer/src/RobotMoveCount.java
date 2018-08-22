/**
 * 机器人的运动范围：
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class RobotMoveCount {

    public static void main(String[] args){
        int threshold = 10;
        int rows = 1;
        int cols = 100;
        int result = new RobotMoveCount().movingCount(threshold, rows, cols);
//        boolean result = new RobotMoveCount().canEnter(threshold, rows, cols);
        System.out.println(result);
    }


    public int movingCount(int threshold, int rows, int cols)
    {
        int count = 0;
        boolean[] visited = new boolean[rows*cols];
        return movingCountHelper(threshold, rows, cols, 0, 0, visited);
    }

    public int movingCountHelper(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int index = row*cols+col;
        if(row<0 || row >= rows || col<0 || col>=cols || visited[index] || !canEnter(threshold, row, col)){
            return 0;
        }
        visited[index] = true;
        return 1+movingCountHelper(threshold, rows, cols, row-1, col, visited)
                +movingCountHelper(threshold, rows, cols, row+1, col, visited)
                +movingCountHelper(threshold, rows, cols, row, col-1, visited)
                +movingCountHelper(threshold, rows, cols, row, col+1, visited);

    }


    public boolean canEnter(int k, int row, int col){
        int coordinateSum = 0;
        String rowStr = String.valueOf(row);
        for (int i = 0; i < rowStr.length(); i++) {
            coordinateSum += Integer.parseInt(String.valueOf(rowStr.charAt(i)));
        }
        String colStr = String.valueOf(col);
        for (int i = 0; i < colStr.length(); i++) {
            coordinateSum += Integer.parseInt(String.valueOf(colStr.charAt(i)));
        }
        return coordinateSum <= k;
    }
}
