package Souhu;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            for(int i=0;i<k;i++) {
                System.out.print(a[i]);
                if (i!=k-1)
                    System.out.print(",");
            }
        }
    }
}
