/**
 * 整数中1出现的次数（从1-n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以
 * 很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class number_1_between1andN {
    public static void main(String[] args){
        int result = new number_1_between1andN().NumberOf1Between1AndN_Solution(13);
        System.out.println(result);
    }

    /**
     * 规律：
     *  一、1的数目
     *
     * 编程之美上给出的规律：
     * 1. 如果第i位（自右至左，从1开始标号）上的数字为0，则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），等于更高位数字X当前位数的权重10i-1。
     * 2. 如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），等于更高位数字X当前位数的权重10i-1+（低位数字+1）。
     * 3. 如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），等于（更高位数字+1）X当前位数的权重10i-1。
     *
     * 二、X的数目
     *
     * 这里的  X∈[1,9] ，因为  X=0  不符合下列规律，需要单独计算。
     * 首先要知道以下的规律：
     *     从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
     *     从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
     *     从 1 至 1000，在它们的百位数中，任意的 X 都出现了 100 次。
     *
     * 依此类推，从 1 至  10 i ，在它们的左数第二位（右数第  i  位）中，任意的 X 都出现了  10 i−1  次。
     * 这个规律很容易验证，这里不再多做说明。
     * 接下来以  n=2593,X=5  为例来解释如何得到数学公式。从 1 至 2593 中，数字 5 总计出现了 813 次，其中有 259 次出现在个位，260 次出现在十位，294 次出现在百位，0 次出现在千位。
     *
     *  总结一下以上的算法，可以看到，当计算右数第  i  位包含的 X 的个数时：
     *
     *     取第  i  位左边（高位）的数字，乘以  10 i−1 ，得到基础值  a 。
     *     取第  i  位数字，计算修正值：
     *         如果大于 X，则结果为  a+ 10 i−1 。
     *         如果小于 X，则结果为  a 。
     *         如果等 X，则取第  i  位右边（低位）数字，设为  b ，最后结果为  a+b+1 。
     *
     * 相应的代码非常简单，效率也非常高，时间复杂度只有  O( log10 n) 。
     * @param n
     * @return
     */

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<0)
            return 0;
        int high, low, curr, temp, i=1;
        int total = 0;
        int len = String.valueOf(n).length();
        while(i<=len){
            high = n/(int)Math.pow(10,i); //获取第i位的高位
            temp = n%(int)Math.pow(10,i);
            curr = temp/(int)Math.pow(10,i-1); //获取第i位
            low = temp%(int)Math.pow(10,i-1);   //获取第i位的低位
            if(curr==1){
                total += high*(int)Math.pow(10,i-1)+low+1;
            }
            else if(curr<1){
                total += high*(int)Math.pow(10,i-1);
            }
            else{
                total += (high+1)*(int)Math.pow(10,i-1);
            }
            i++;
        }
        return total;
    }

}
