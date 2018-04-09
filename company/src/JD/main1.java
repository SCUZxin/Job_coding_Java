package JD;
import java.util.*;

public class main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int t =in.nextInt();
            int[] N = new int[t];
            int[] X = new int[t];//奇数
            int[] Y = new int[t];//偶数
            for(int i=0;i<t;i++) {
                N[i] = in.nextInt();
            }
            decompos(N, X, Y, t);
        }
    }

    public static void decompos(int[] N, int[] X, int[] Y, int t){
        for (int j = 0; j < N.length; j++) {
            //值是偶数才能分解(奇数，无法分解，输出“No”)
            if (N[j] % 2 == 0) {
                for (int k = 2; k <= N[j]; k += 2) {
                    if (N[j] % k == 0) {
                        X[j] = N[j] / k;
                        Y[j] = k;
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < t; j++) {
            if (X[j] == 0) {    //没有找到
                System.out.println("No");
            } else {
                System.out.println(X[j] + " " + Y[j]);
            }
        }
    }

}
