package Meituan;

import java.util.Scanner;

public class main1{

    public static int Gcd(int a,int b) {
        return b==0?a:Gcd(b,a%b);
    }

    public static void main(String[] args) {
        int N,n,m,p;
        long[] A = new long[100005];

        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        n=sc.nextInt();
        m=sc.nextInt();
        p=sc.nextInt();

        A[1] =p;
        for(int i=2;i<=N;i++)
        {
            A[i] = (A[i-1]+153) %p ;
        }
        long res =0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                res += A[Gcd(i,j)];//应该是long  res += (long)(A[Gcd(i,j)]);
            }
        }
        System.out.println(res);
    }
}