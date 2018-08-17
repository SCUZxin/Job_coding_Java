/**
 * 表示数值的字符串:
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
    public static void main(String[] args){
        String str = "5e2";
        boolean result = new IsNumeric().isNumeric(str.toCharArray());
        System.out.println(result);
    }

    public boolean isNumeric(char[] str) {
        int len = str.length;
        if(len == 0){
            return false;
        }

        String s=String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
    }
}
