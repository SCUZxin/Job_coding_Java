package company.src.ByteDance3;

import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine().trim());
        String[] strs = input.nextLine().split("\\s+");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        boolean flag = true;
        flag = fun(a, flag, N);
        if (flag){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    public static boolean fun(int[] a, boolean flag, int N) {
        for (int i = 0; i < N; i++) {
            if (i == a.length-1 && a[i]<=127){
                continue;
            }
            String[] split = Integer.toBinaryString(a[i]).split("");
            for (int j = 0; j < N-1; j++) {
                if (!split[j].equals("1")){
                    flag = false;
                }
            }
            if (!split[N-1].equals("0")){
                flag = false;
            }
            N--;
        }
        return flag;
    }

}
