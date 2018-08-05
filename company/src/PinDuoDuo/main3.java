package company.src.PinDuoDuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strs = input.nextLine().split("\\s+");
        int N = Integer.parseInt(strs[0]);
        int judgeNum = Integer.parseInt(strs[1]);
        int [][]userSerial = new int[N][];
        for (int i = 0; i < N; i++) {
            String[] friends = input.nextLine().split("\\s+");
            userSerial[i] = new int[friends.length];
            for (int j = 0; j < friends.length; j++) {
                userSerial[i][j] = Integer.parseInt(friends[j]);
            }
        }

        int count[] = new int[N];
        Arrays.fill(count, 0);
        for (int i = 0; i < N; i++) {
            if(i!=judgeNum){
                count[i] = sameNum(userSerial[judgeNum], userSerial[i]);
            }
        }

        int max = 0;
        int userId = -1;
        for (int i = 0; i < N; i++) {
            if(count[i]>max){
                userId = i;
                max = count[i];
            }
        }

        System.out.println(userId);
    }


    public static int sameNum(int[] array1, int[] array2){
        int count=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            if(list.contains(array2[i]))
                count++;
        }
        return count;
    }

}
