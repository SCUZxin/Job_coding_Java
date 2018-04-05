package Tencent;

import java.util.HashMap;
import java.util.Scanner;

public class main1 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(in.next());
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i], i);
        }

        return result;
    }

}
