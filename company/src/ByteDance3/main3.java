package company.src.ByteDance3;

import java.util.Scanner;
/*

 */
public class main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ipStr = input.nextLine().trim();
        int len = ipStr.length();
        int count = 0;
//        if(len<=3 || len>=13){
//            return;
//        }
        if(len == 4){
            count = 1;
        }
//        else if(len == 5){
//            count = 4;
//        }
        else{
            count = getCount(ipStr, len, count);
        }
        System.out.println(count);
    }

    public static int getCount(String ipStr, int len, int count) {
        //记录IP地址的4个部分
        String str1 = "",str2="",str3="",str4="";
        for (int i = 1; i <= len-3; i++) {
            str1 = ipStr.substring(0, i);
            if(!isValidNum(str1)){
                break;
            }
            for (int j = i+1; j <= len-2; j++) {
                str2 = ipStr.substring(i, j);
                if(!isValidNum(str2)){
                    break;
                }
                for (int k = j+1; k <= len-1; k++) {
                    str3 = ipStr.substring(j, k);
                    if(!isValidNum(str3)){
                        break;
                    }
                    str4 = ipStr.substring(k, len);
                    if(!isValidNum(str4)){
                        break;
                    }
                    count++;
                }
            }
        }
        return count;
    }


    public static boolean isValidNum(String str){
        int strNum = Integer.parseInt(str);
        if(str.length() >= 2){
            if(str.charAt(0)=='0'){
                return false;
            }
        }
        return strNum >=0 && strNum <= 255;
    }

}
