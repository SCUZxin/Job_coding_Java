package company.src.XieCheng;

import java.util.*;

/*
2
p 1 1
p 2 2
g 1
p 2 102
p 3 3
g 1
g 2
g 3


1
1
-1
3
 */

public class main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        while(input.hasNextLine()){
            String[] inLine = input.nextLine().split("\\s+");
            if("p".equals(inLine[0])){
                int key = Integer.parseInt(inLine[1]);
                int value = Integer.parseInt(inLine[2]);
                if(!map.containsKey(key)){
                    //找到最近最少使用的清除
                    if(map.size()==num){
                        clearLeastUsed(map, count);
                    }
                    count.put(key, 1);
                }
                map.put(key, value);
            }
            else if("g".equals(inLine[0])){
                int key = Integer.parseInt(inLine[1]);
                count.put(key, count.get(key)+1);
            }
        }
    }

    private static void clearLeastUsed(Map<Integer, Integer> map, Map<Integer, Integer> count) {
        Collection<Integer> c = count.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        int minValue = (Integer)obj[0];
        System.out.println("min:"+minValue);
        for(Integer key:map.keySet()){
            if(minValue == map.get(key)){
                map.remove(key);
                return;
            }
        }
    }


}
