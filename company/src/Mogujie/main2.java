package Mogujie;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] string = str.split(",");
        int[] ratings = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            ratings[i] = Integer.valueOf(string[i]).intValue();
        }
        System.out.println(candy(ratings, ratings.length));

    }

    public static int candy(int[] ratings, int len){
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);

        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
        }
        int sum = candy[len-1];
        for(int j=len-2;j>=0;j--){
            if(ratings[j] > ratings[j+1]){
                candy[j] = Math.max(candy[j], candy[j+1]+1);
            }
            sum += candy[j];
        }
        return sum;
    }
}