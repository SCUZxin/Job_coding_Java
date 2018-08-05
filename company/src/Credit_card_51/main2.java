package company.src.Credit_card_51;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] RGB = str.toCharArray();
        Arrays.sort(RGB);
        for (int i = RGB.length-1; i >=0; i--) {
            System.out.print(RGB[i]);
        }

    }
}
