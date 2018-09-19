package company.src.ByteDance2;

import java.util.Scanner;

public class main5 {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n =scan.nextInt();
        int min=n;
        int[] list =new int[n];
        for(int i =0;i<n;i++) {
            list[i]=scan.nextInt();
        }
        func();
        System.out.println(min);
    }
    private static int func() {

        return 0;
    }
}