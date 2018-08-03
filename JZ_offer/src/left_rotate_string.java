/**
 * 左旋转字符串：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class left_rotate_string {
    public static void main(String[] args){
        String str = "abcXYZdef";
        int n = 3;
        String result = new left_rotate_string().LeftRotateString(str, n);
        System.out.println(result);
    }

    //法二：
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len <= 0)
            return "";
        n = n % len;
        str += str;
        return str.substring(n, len+n);
    }

    //法一：
    public String LeftRotateString_1(String str,int n) {
        int len = str.length();
        if(len <= 0)
            return "";
        int originIndex = n%len;
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = originIndex; i < len; i++) {
            sb.append(cs[i]);
        }

        for (int i = 0; i < originIndex; i++) {
            sb.append(cs[i]);
        }
        return sb.toString();
    }
}
