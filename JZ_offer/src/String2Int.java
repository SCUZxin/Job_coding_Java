/**
 * 把字符串转换成整数：
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class String2Int {

    public static void main(String[] args){
        String str = "-2147483647";
        int result = new String2Int().StrToInt(str);
        System.out.println(result);
    }

    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] cs = str.toCharArray();
        char currChar;
        int symbol = 0;
        int sum = 0;
        if(cs[0]=='-'){
            symbol = 1;
        }
        for (int i = symbol; i < cs.length; i++) {
            currChar = cs[i];
            if(currChar=='+'){
                continue;
            }
            if((currChar < '0' || currChar > '9')){
                return 0;
            }
            sum = sum*10 + currChar - 48;//'0'=48, '9'=57
        }

        return symbol==0? sum: sum*-1;
    }

}
