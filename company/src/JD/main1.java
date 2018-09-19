package company.src.JD;
import java.util.*;

public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int M = input.nextInt();
            int[][] node = new int[M][2];
            for (int j = 0; j < M; j++) {
                node[j][0] = input.nextInt();
                node[j][1] = input.nextInt();
            }
//            for (int j = 0; j < M; j++) {
//                System.out.println(Arrays.toString(node[j]));
//            }
            boolean findNodeLinkedAll = false;
            boolean findNodeNotLinkedAll = false;
            for (int j = 0; j < N; j++) {
                if(findNodeLinkedAll(j, N, M, node)){
                    findNodeLinkedAll = true;
                    break;
                }
            }
            for (int j = 0; j < N; j++) {
                if(findNodeNotLinkedAll(j, N, M, node)){
                    findNodeNotLinkedAll = true;
                    break;
                }
            }
            if(findNodeLinkedAll && findNodeNotLinkedAll){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }

    }

//    private static boolean findNodeLinkedAll(int targetNode, int n, int m, int[][] node) {
//        Set<Integer> set = new TreeSet<>();
//        set.add(targetNode);
//        for (int i = 0; i < m; i++) {
//            if(node[i][0]==targetNode){
//                set.add(node[i][1]);
//            }
//            if(node[i][1]==targetNode){
//                set.add(node[i][0]);
//            }
//        }
//        if(set.size() != n){
//            return false;
//        }
//        int i=1;
//        for (Integer val : set) {
//            if(val!=i++){
//                return false;
//            }
//        }
//        return true;
//    }


    private static boolean findNodeLinkedAll(int targetNode, int n, int m, int[][] node) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if(node[i][0]==targetNode || node[i][1]==targetNode){
                count++;
            }
        }
        return count == n-1;
    }

    private static boolean findNodeNotLinkedAll(int targetNode, int n, int m, int[][] node) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if(node[i][0]==targetNode || node[i][1]==targetNode){
                count++;
            }
        }
        return count != n-1;
    }

}
