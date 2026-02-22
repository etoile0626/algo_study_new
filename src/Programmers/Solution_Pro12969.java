package Programmers;

/*

 */
import java.util.Scanner;

public class Solution_Pro12969 {                            //직사각형 별찍기
    class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < b; i++){
                for(int j = 0; j < a; j++){
                    sb.append("*");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
        }
    }
}
