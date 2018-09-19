package company.src.XieCheng;

import java.util.*;

public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Long inNum = input.nextLong();
        int result = numberOf1(inNum);
        System.out.println(result);
    }

    public static int numberOf1(Long inNum){
        int count1=0;
        while(inNum != 0){
            inNum = inNum & (inNum-1);
            count1++;
        }
        return count1;
    }

}
