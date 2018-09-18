package company.src.Tencent;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        Point[] inN = new Point[N];
        Point[] inM = new Point[M];
        for (int i = 0; i < N; i++) {
            inN[i] = new Point();
            inN[i].x = input.nextInt();
            inN[i].y = input.nextInt();
        }
        for (int i = 0; i < M; i++) {
            inM[i] = new Point();
            inM[i].x = input.nextInt();
            inM[i].y = input.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int disSum = 0;
            for (int j = 0; j < N; j++) {
                disSum += Point.distance(inM[i],inN[j]);
            }
            System.out.println(disSum);
        }
    }

}

class Point{
    int x;
    int y;
    public static int distance(Point p1, Point p2){
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
}

//前缀和：ACM铜奖做过，直接用
//#include<bits/stdc++.h>
////#include<windows.h>
//        using namespace std;
//
//
//        typedef long long ll;
//        typedef unsigned long long ull;
//        #define mp make_pair
//        #define mod 1000000007
//
//        vector<int> a,b;
//        int prea[200005],preb[200005];
//
//        int main()
//        {
//        int n,m,ta,tb,x,y;
//        while(cin>>n>>m)
//        {
//        for(int i=0;i<n;i++)
//        {
//        cin>>ta>>tb;
//        a.push_back(ta);
//        b.push_back(tb);
//        }
//        sort(a.begin(),a.end());
//        sort(b.begin(),b.end());
//        memset(prea,0,sizeof(prea));
//        memset(preb,0,sizeof(preb));
//        prea[1] =a[0];
//        preb[1] =b[0];
//        for(int i=2;i<=n;i++)
//        {
//        prea[i] = prea[i-1]+a[i-1];
//        preb[i] = preb[i-1]+b[i-1];
//        }
//        //for(int i=1;i<=n;i++)
//        //    cout<<prea[i]<<" ";
//        //cout<<endl;
//
//
//        while(m--)
//        {
//        ll res=0;
//        cin>>x>>y;
//        int tmp = upper_bound(a.begin(),a.end(),x)-a.begin();
//        //cout<<tmp<<" "<<prea[tmp]<<" "<<prea[n]<<endl;
//        res+= (tmp*x - prea[tmp]) + (prea[n]-prea[tmp])-(n-tmp)*x ;
//
//        tmp = upper_bound(b.begin(),b.end(),y)-b.begin();
//        res+= (tmp*y - preb[tmp]) + (preb[n]-preb[tmp])-(n-tmp)*y ;
//
//        cout<<res<<endl;
//        }
//        }
//        return 0;
//        }