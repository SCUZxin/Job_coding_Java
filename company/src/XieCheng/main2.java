package company.src.XieCheng;

import java.util.Scanner;

/*
6
20180602
1013 20180103 20180105
1022 20180102 20180103
1103 20180104 20180106
1034 20180101 20180102
1105 20180201 20180204
1106 20180601 20180604

 */
public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int recordCount = input.nextInt();
        int time = input.nextInt();
        int[][] record = new int[recordCount][3];
        for (int i = 0; i < recordCount; i++) {
            record[i][0] = input.nextInt();
            record[i][1] = input.nextInt();
            record[i][2] = input.nextInt();
        }
        int flag = 0;
        for (int i = 0; i < recordCount; i++) {
            if(time >= record[i][1] && time <= record[i][2]){
                System.out.println(record[i][0]);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println("null");
        }
    }
}
