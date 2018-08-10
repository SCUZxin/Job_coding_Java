/**
 * 不用加减乘除做加法：
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add_without_arithmetic {
    public static void main(String[] args){
        int result = new Add_without_arithmetic().Add(5,7);
        System.out.println(result);
    }

    // eg:5~101，7~111
    // 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
    // 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
    // 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1
    public int Add(int num1,int num2) {
        //还有进位，就循环
        while(num2 != 0){
            int temp = num1 ^ num2;     //非进位位直接进行加操作后的结果
            num2 = (num1 & num2) << 1;  //进位后的结果
            num1 = temp;
        }

        return num1;
    }
}
