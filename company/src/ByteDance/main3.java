package company.src.ByteDance;

import java.util.Arrays;
import java.util.Scanner;

/*
3
2
helloworld
hdlrowolle
2
helloworld
worldhello
2
abcde
acbde
 */


public class main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = Integer.parseInt(input.nextLine().trim().toString());
        int[] n = new int[t];
        String [][] str = new String[t][];
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(input.nextLine().trim().toString());
            str[i] = new String[n[i]];
            for (int j = 0; j < n[i]; j++) {
                str[i][j] = input.nextLine().trim();
            }

        }

//        System.out.println(Arrays.toString(n));
        for (int i = 0; i < t; i++) {
//            System.out.println(n[i]);
            int flag = 0;
            for (int j = 0; j < n[i]; j++) {
                if(flag == 1){
                    break;
                }
                for (int k = j+1; k < n[i]; k++) {
                    if(judgeTwinStr(str[i][j], str[i][k])){
                        System.out.println("Yeah");
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0){
                System.out.println("Sad");
            }
        }
    }


    public static boolean judgeTwinStr(String str1, String str2){
        int lenStr1 = str1.length();
        int lenStr2 = str2.length();
        if(lenStr1 != lenStr2 || lenStr1 < 1){
            return false;
        }
        if(lenStr1 == 1){
            if(str1.equals(str2)){
                return true;
            }
            else{
                return false;
            }
        }

        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();

        for (int i = 0; i < lenStr1; i++) {
            //找到第一个字符
            if(cs2[0] == cs1[i]) {
                if(judgeBack(lenStr1, lenStr2, cs1, cs2, i)||judgeForward(lenStr1, lenStr2, cs1, cs2, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean judgeBack(int lenStr1, int lenStr2, char[] cs1, char[] cs2, int i) {
        //从该字符往后继续  <--
        int indexJ = 1;
        int indexI = (i+lenStr1-1)%lenStr1;
        while(indexJ<lenStr2){
            if(cs1[indexI] != cs2[indexJ]){
                return false;
            }
            indexI = (indexI+lenStr1-1)%lenStr1;
            indexJ++;
        }
        return true;
    }
    public static boolean judgeForward(int lenStr1, int lenStr2, char[] cs1, char[] cs2, int i) {
        //从该字符往前继续 -->
        int indexJ = 1;
        int indexI = (i+lenStr1+1)%lenStr1;
        while(indexJ<lenStr2){
            if(cs1[indexI] != cs2[indexJ]){
                return false;
            }
            indexI = (indexI+1)%lenStr1;
            indexJ++;
        }
        return true;
    }

}
