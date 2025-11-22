package BaekJoon;

import java.util.Scanner;

public class Main_BJ1427 {                  //소트인사이드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        int n = sc.nextInt();

        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            while (arr[i]-- > 0) {
                System.out.print(i);
            }
        }
    }
}
