package company.src.ByteDance3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main5 {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int N =input.nextInt();
        int M =input.nextInt();

        int[][] relation = new int[N][N];
        Set<Integer>[] care = new HashSet[N];

        int result = 0;
        for(int i=0;i<N;i++){
            care[i] = new HashSet<>();
            for(int j=0;j<N;j++){
                if(i==j)
                    relation[i][j]=1;
                else
                    relation[i][j]=0;
            }
            care[i].add(i);
        }
        for (int i=0;i<M;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            relation[x-1][y-1] = 1;
        }

        result = getResult(N, relation, care, result);
        System.out.println(result);

    }

    public static int getResult(int n, int[][] relation, Set<Integer>[] care, int result) {
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i< n; i++){
                for (int j = 0; j< n; j++){
                    if (j!=i && relation[j][i]==1){
                        int before = care[i].size();
                        care[i].addAll(care[j]);
                        int after = care[i].size();
                        if (after>before){
                            flag = true;
                            if (after== n)
                                result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}


