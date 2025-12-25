package BaekJoon;

import java.util.Scanner;

public class Main_BJ9655 {              //돌 게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println((n % 2 == 1) ? "SK" : "CY");
    }
}
