package company.src.NeteaseGame;

import java.util.Scanner;

/*
3
5 2 113221101000101
13 7 1016
4 12 2222248A

 */
public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
        int num = Integer.parseInt(input.nextLine().trim().toString());
        int [] first = new int[num];
        int [] second = new int[num];
        String[] numStr = new String[num];
        for (int i = 0; i < num; i++) {
            String[] line = input.nextLine().trim().split("\\s+");
            first[i] = Integer.parseInt(line[0]);
            second[i] = Integer.parseInt(line[1]);
            numStr[i] = line[2].toLowerCase();
        }

        for (int i = 0; i < num; i++) {
//            System.out.println("first: "+first[i]);
            int len = numStr[i].length();
            for (int j = 1; j < len; j++) {
                String numStr1 = numStr[i].substring(0,j);
                String numStr2 = numStr[i].substring(j,len);
                int deicmal = toDecimal(numStr1, first[i]);
                if(isValid(numStr2, second[i], deicmal)){
                    System.out.println(deicmal);
                    break;
                }
            }
        }
//        int decimal = Integer.valueOf("22222", 4);
//        System.out.println(decimal);
//        System.out.println(Integer.toString(decimal, 12));
//        System.out.println(4*12*12+8*12+10);

    }

    public static int toDecimal(String numStr1, int first){
        int decimal = Integer.valueOf(numStr1, first);
        return decimal;
    }
    public static boolean isValid(String numStr2, int second, int decimal){
        if(numStr2.equals(Integer.toString(decimal, second))){
            return true;
        }
        return false;
    }

}
