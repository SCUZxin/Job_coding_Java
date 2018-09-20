package company.src.ByteDance4;

import java.util.Arrays;
import java.util.Scanner;

/*
字符串唯一前缀标识：
输入：
5
bytedance
toutiaohao
toutiaoapp
iesaweme
iestiktok

输出：
b
toutiaoh
toutiaoa
iesa
iest
 */
public class main2 {
//    final int MAX = 10000+10;
    static String[] str =  new String[1001];
    static int[][] ch = new int[100001][30];
    static int[] word = new int[100001];//记录当前节点下有几个单词
    static int sz = 1;//节点数

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine().trim());
//        System.out.println("N:"+N);
        for (int i = 0; i < N; i++) {
            str[i] = input.nextLine().trim();
            insert(str[i]);
        }

        for(int i = 0; i < N; i++)
        {
//            System.out.println("str.length:"+str.length);
            find(str[i]);
//            System.out.println();
        }
    }



    static int idx(char x)//字母编号
    {
        return x-'a';
    }
    static void insert(String s)//插入
    {
        int l = s.length();
        int u = 0;
        for(int i = 0; i < l; i++)
        {
            int c = idx(s.charAt(i));
            if(ch[u][c]<=0)//节点不存在
            {
                Arrays.fill(ch[sz], 0);
                ch[u][c] = sz;
                sz++; //节点数自增一
            }
            u = ch[u][c];
            word[u]++;//单词数加一
        }
    }
    static void find(String s)//查询
    {
        int l = s.length();
        int u = 0;//从根节点开始
        for(int i = 0; i < l; i++)
        {
            int c = idx(s.charAt(i));
            u = ch[u][c];
            System.out.print(s.charAt(i));
            if(word[u] == 1) {//当前前缀足以找出单词
                System.out.println();
                return;
            }
        }
    }
}


