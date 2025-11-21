package BaekJoon;

import java.util.Scanner;

public class Main_BJ10872 {                         //팩토리얼

    static long pact(int n){
        if(n <= 1){
            return 1;
        } else {
            return n * pact(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(pact(n));
    }
}
