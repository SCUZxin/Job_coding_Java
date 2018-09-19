package company.src.ByteDance2;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strIn = input.nextLine().trim();
        int result = func();
        System.out.println(result);
    }

    public static int func(){

        return 0;
    }

    public static boolean isValidInteger(String str){
        int len = str.length();
        if(str.charAt(0)=='0' && len!=1)
            return false;
        return true;
    }

    public static boolean isValidDecimal(String str){
        int len = str.length();
        return true;
    }

}
