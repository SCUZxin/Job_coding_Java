package company.src.NeteaseGame;

import java.util.Scanner;

/*
3
DCBA
ZABCDEFGX
XYZABCDMMMGHIJKLRST

 */
public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
//        int num = Integer.parseInt(input.nextLine().trim().toString());
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = input.nextLine().trim();
        }
        for (int i = 0; i < num; i++) {
            System.out.println(findAndReplace(strs[i]));
        }

    }

    public static String findAndReplace(String str){
        int len = str.length();
        if(len < 4){
            return str;
        }
        String retStr = "";
        char[] cs = str.toCharArray();
        int startIndex = 0;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if(i==len-1){
                if(count>=4 && cs[i] != cs[i-1]+1){
                    retStr += String.valueOf(cs[startIndex])+"-"+String.valueOf(cs[i-1]);
                    retStr += String.valueOf(cs[i]);
                }
                else if(count==3 && cs[i] == cs[i-1]+1){
                    retStr += String.valueOf(cs[startIndex])+"-"+String.valueOf(cs[i]);
                }
                else{
                    for (int j = startIndex; j <= i; j++) {
                        retStr += String.valueOf(cs[j]);
                    }
                }
            }
            else{
                if(cs[i] == cs[i-1]+1){
                    count++;
                }
                else{
                    if(count >= 4){
                        retStr += String.valueOf(cs[startIndex])+"-"+String.valueOf(cs[i-1]);
                    }else{
                        for (int j = startIndex; j < i; j++) {
                            retStr += String.valueOf(cs[j]);
                        }
                    }
                    startIndex = i;
                    count = 1;
                }
            }
        }
        return retStr;
    }
}
