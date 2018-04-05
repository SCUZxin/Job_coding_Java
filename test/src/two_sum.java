import java.util.HashMap;
import java.util.Scanner;

public class two_sum {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n"); //使用空格或逗号或点号作为分隔符
        while(in.hasNext()){
            System.out.println(in.next());
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i], i);
        }
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                result[0] = i+1;
                result[1] = map.get(target - numbers[i])+1;
                if(result[0] != result[1])
                    return result;
            }
        }

        return null;
    }

}

//    public static int[] twoSum(int[] numbers, int target) {
//        HashMap<Integer, Integer> map = new HashMap();
//        int[] result = new int[2];
//        for(int i=0;i<numbers.length;i++){
//            if(map.containsKey(target - numbers[i])){
//                result[0] = map.get(target - numbers[i])+1;
//                result[1] = i+1;
//                return result;
//            }
//            else{
//                map.put(numbers[i], i);
//            }
//        }
//        return null;
//    }
