import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 顺时针打印矩阵：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class print_matrix {
    public static void main(String[] args){
//        int[][] matrix = new int[4][4];
//        for (int i = 1; i <= 4; i++) {
//            for (int j = 1; j <= 4; j++) {
//                matrix[i-1][j-1] = 4*(i-1)+j;
//            }
//        }
        int[][] matrix = {{1},{2},{3},{4},{5}};
        ArrayList ret = new print_matrix().printMatrix(matrix);
        System.out.println(ret);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        if(row==0 || col==0)
            return ret;
        int left=0, top=0, right=col-1, bottom=row-1;
        while(left<=right && bottom>=top){//right=0;bottom=4;
            //left -> right
            for (int i = left; i <= right; i++) {
                ret.add(matrix[top][i]);
            }
            //top -> bottom
            for (int i = top+1; i <= bottom; i++) {
                ret.add(matrix[i][right]);
            }
            //right -> left
            if (top != bottom) { //eg；[[1,2,3,4,5]]
                for (int i = right - 1; i >= left; i--) {
                    ret.add(matrix[bottom][i]);
                }
            }
            //bottom -> top
            if(left != right) {  //[[1],[2],[3],[4],[5]]
                for (int i = bottom - 1; i > top; i--) {
                    ret.add(matrix[i][left]);
                }
            }
            left++; right--; top++; bottom--;
        }
        return ret;
    }
}
