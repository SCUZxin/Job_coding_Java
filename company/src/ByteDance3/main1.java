package company.src.ByteDance3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
最大不重复字串：LeetCode第3题
    "滑动窗口"
    比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
    然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
    然后如果没有重复的就正常添加，
    有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
*/
public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().trim();
        int result = longestSubString(str);
        System.out.println(result);
    }

    public static int longestSubString(String str) {
        if(str == null) {
            return 0;
        }
        int len = str.length();
        if(len == 1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        char[] cs = str.toCharArray();
        for(int i=0; i<len; i++){
            char  c = cs[i];
            left = Math.max(left,(map.containsKey(c))? map.get(c)+1:0);
            max = Math.max(max, i-left+1);
            map.put(c,i);
        }
        return max;

    }
}
