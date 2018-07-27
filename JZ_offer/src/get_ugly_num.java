import java.util.Arrays;

/**
 * 丑数:
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class get_ugly_num {
    public static void main(String[] args){
        int result = new get_ugly_num().GetUglyNumber_Solution(50);
        System.out.println(result);
    }

    //思路： 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的数
    //判断是否是丑数的方法：
    // 首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。
    // 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        int[] ugly = new int[index];
        int i = 1, i2=0, i3=0, i5=0, temp=0;
        ugly[0] = 1;
        while(i < index){
            temp = Math.min(ugly[i2]*2, Math.min(ugly[i3]*3, ugly[i5]*5));
            //三条if防止值是一样的，不要改成else的
            if(temp == ugly[i2]*2) i2++;
            if(temp == ugly[i3]*3) i3++;
            if(temp == ugly[i5]*5) i5++;
            ugly[i++] = temp;
        }
        System.out.println(Arrays.toString(ugly));
        return ugly[index-1];
    }

}
