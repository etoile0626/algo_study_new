package BaekJoon;

import java.util.Scanner;

public class Main_BJ11653 {                 //소인수분해
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(n); i++) {	// 또는 i * i <= n
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }
        if (n != 1) {
            System.out.println(n);
        }
    }
}
