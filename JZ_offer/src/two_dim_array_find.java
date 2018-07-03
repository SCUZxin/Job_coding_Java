/**
 * 二维数组的查找：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：取右上角或者左下角为起始点，进行遍历，本例取左下角
 *
 * 测试用例：7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 */

public class two_dim_array_find {
    public static void main(String[] args){
        int target = 7;
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean restult = new two_dim_array_find().Find(target, array);
        System.out.println(restult);
    }

    public boolean Find(int target, int [][] array) {
        int len = array.length;
        int i=len-1,j=0;
        while(i>=0 && j<array[i].length){
            if(target == array[i][j]){
                return true;
            }else if(target > array[i][j]){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
}
