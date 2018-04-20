package IQiYi;

import java.util.Scanner;

/**
 * 字符串S的字典序最大的子序列
 */
public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String S = sc.next();
            System.out.println(maxSubSequence(S));
        }
    }

    public static String maxSubSequence(String S){
        StringBuilder sb = new StringBuilder();
        int len = S.length();
        char[] chs = S.toCharArray();
        int max = 0;
        char[] ret = new char[len];
        int index = len;
        for(int i=len-1;i>=0;i--){
            if(chs[i]>=max){
                ret[--index] = chs[i];
                max = chs[i];
            }
        }
        for(int i=index;i<len;i++){
            sb.append(ret[i]);
        }
        return sb.toString();
    }
}
