package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*

 */

public class Main_BJ10773 {                     //제로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<Integer>();

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {	// 0이라면 스택에 저장된 top 원소를 지운다.
                s.pop();
            }
            else {	// 아닐경우는 스택에 원소 추가
                s.push(n);
            }
        }

        int sum = 0;
        for(int o : s) {	// 스택에 담긴 원소 합 구하기
            sum += o;
        }

        System.out.println(sum);
    }
}
