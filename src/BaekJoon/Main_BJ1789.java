package BaekJoon;

import java.util.Scanner;

public class Main_BJ1789 {                          //수들의 합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();
        long plus = 1;
        long sum = 0;

        while(true) {
            sum += plus;

            if(sum>s) {
                break;
            }

            plus++;
        }

        System.out.println(plus-1);
    }
}
