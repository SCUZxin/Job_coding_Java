package company.src.Souhu;

import java.util.*;

public class main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int lineNum = sc.nextInt();
            int[][] rule = new int[lineNum][];
            int ruleFlag = 0;
            for(int i=0;i<lineNum;i++){
                ruleFlag = sc.nextInt();
                if(ruleFlag == 1){  //每日成长值规则，4列
                    rule[i] = new int[4];
                    rule[i][0] = ruleFlag;
                    for(int j=1;j<4;j++)
                        rule[i][j] = sc.nextInt();
                }
                else if(ruleFlag == 2){  //任务成长值规则，3列
                    rule[i] = new int[3];
                    rule[i][0] = ruleFlag;
                    for(int j=1;j<3;j++)
                        rule[i][j] = sc.nextInt();
                }
            }
            System.out.println(userValue(rule));
        }
    }

    public static int userValue(int[][] rule){
//        map<key, value>:第key天的成长值value
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int start = 0;
        int end = 0;
        int temp;
        for(int i=0;i<rule.length;i++){
            if(rule[i][0] == 2){    //任务成长值
                sum += rule[i][2];
            }
            else{   //每日成长值
                start = rule[i][1];
                end = rule[i][2];
                for(int k=start;k<=end;k++){
                    temp = -9999;
                    if(map.containsKey(k))
                        temp = map.get(k);
                    if(rule[i][3] > temp)
                        map.put(k, rule[i][3]);
                }
            }
        }
        List<Integer> valuesList = new ArrayList<>(map.values());
        for(Integer value: valuesList){
            sum += value;
        }
        return sum;
    }
}

//3
//1 1 5 10
//2 3 4
//1 4 6 -5
