package company.src.PinDuoDuo;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strIn = input.nextLine().trim();
        int result = func(strIn);
        System.out.println(result);
    }

    public static int func(String strIn){
        int count=0, firCount=0, lastCount=0;
        int len = strIn.length();
        String first = "",last = "";
        for (int i = 1; i < len; i++) {
            firCount=0;lastCount=0;
            first = strIn.substring(0,i);
            last = strIn.substring(i, len);
            if(isValidInteger(first))
                firCount++;
            if(isValidInteger(last))
                lastCount++;
            int firstLen = first.length();
            int lastLen = last.length();
            for (int m = 1; m < firstLen; m++) {
                if(isValidDecimal(first.substring(0,m)+"."+first.substring(m)))
                    firCount++;
            }
            for (int n = 1; n < lastLen; n++) {
                if(isValidDecimal(last.substring(0,n)+"."+last.substring(n)))
                    lastCount++;
            }
            count += (firCount*lastCount);
        }
        return count;
    }

    public static boolean isValidInteger(String str){
        int len = str.length();
        if(str.charAt(0)=='0' && len!=1)
            return false;
        return true;
    }

    public static boolean isValidDecimal(String str){
        int len = str.length();
        String intPart="";
        if(len>=1){
            intPart = str.split("\\.")[0];
        }

        if(str.charAt(0)=='0' && intPart.length()!=1)
            return false;
        if(str.charAt(str.length()-1)=='0')
            return false;
        if(str.charAt(0)=='.' || str.charAt(str.length()-1)=='.')
            return false;
        return true;
    }

}
