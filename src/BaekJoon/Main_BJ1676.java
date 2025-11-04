package BaekJoon;

import java.util.Scanner;

public class Main_BJ1676 {                          //팩토리얼 0의 개수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int cnt = 0;

        while (num >= 5) {
            cnt += num / 5;
            num /= 5;
        }

        System.out.println(cnt);
    }
}
