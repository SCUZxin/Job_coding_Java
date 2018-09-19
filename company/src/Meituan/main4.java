package company.src.Meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
5 3 2
3 1 1 1 2
 */

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k>n || k<1){
            System.out.println(0);
            return;
        }
        int t = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 1;
        for (int r = k+l-1; r <= n; r++) {
            //满足r-l+1=k;
            map.clear();
            l = r+1-k;
            //在a l , a l+1,...ar中，存在一个数至少出现了 t 次
            for (int i = l; i <= r; i++) {
                if(map.containsKey(a[i-1])){
                    if(map.get(a[i-1]) == t-1){
                        count++;
                        break;
                    }
                    map.put(a[i-1], map.get(a[i-1])+1);
                }else{
                    map.put(a[i-1], 1);
                }
            }
        }

        System.out.println(count);
    }

}