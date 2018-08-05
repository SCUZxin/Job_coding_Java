package test.src;

import java.util.*;
public class main {

    static boolean find = false;

    public static void func(int total, int[] need, int sum, int k, int n)
    {
        if(k+1 <= n)
        {
            if (sum + need[k] == total)
                find = true;
            if (sum + need[k] < total) {
                sum += need[k];
                func(total, need, sum, k + 1, n); // 放入
            }
            func(total, need, sum, k+1, n);  // 不放
        }
    }

//5 100
//10 20 30 40 50


    public static final void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        String[] str1 = line1.split(" ");
        int n = Integer.parseInt(str1[0]);
        int totalSeat = Integer.parseInt(str1[1]);

        String[] str2 = line2.split(" ");
        int[] seatNeed = new int[str2.length];
        for(int i=0;i<str2.length;i++){
            seatNeed[i] = Integer.parseInt(str2[i]);
        }

        func(totalSeat, seatNeed, 0, 0, n);

        if(find)
            System.out.println("perfect");
        else
            System.out.println("good");

    }
}