package company.src.Migu;

import java.util.*;

/*

给定一个文档(Unix-style)的完全路径，请进行路径简化。
样例
"/home/", => "/home"
"/a/./b/../../c/", => "/c"

/home/
/a/././b//../../c/
*/
public class main1 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String str = input.nextLine();
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(spiralOrder(arr)));
    }

    static int[] spiralOrder(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        int[] ret = new int[row*column];
        int left=0, top=0, right=column-1, bottom=row-1,index=0;

        while(left<=right && top<=bottom){
            for (int i = left; i <= right; i++) {
                ret[index++] = arr[top][i];
            }
            for (int i = top+1; i <= bottom; i++) {
                ret[index++] = arr[i][right];
            }
            if(top!=bottom){
                for (int i = right-1; i >= left; i--) {
                    ret[index++] = arr[bottom][i];
                }
            }
            if(left!=right){
                for (int i = bottom-1; i > top ; i--) {
                    ret[index++] = arr[i][left];
                }
            }
            left++;right--;top++;bottom--;
        }
//        System.out.println(index);
//        System.out.println(top);
//        System.out.println(bottom);
//        System.out.println(Arrays.toString(ret));
        return ret;
    }
}
