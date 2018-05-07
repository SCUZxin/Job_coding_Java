package Credit_card_51;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(";");
        String A = str[0];
        String B = str[1];
        for (int i = 0; i < B.length(); i++) {
            if(!A.contains(B.substring(i, i+1))){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
