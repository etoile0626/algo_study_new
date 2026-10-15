package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    재현이는 재민이를 도와서 동아리 장부를 관리하고 있다.
    재현이는 영수증을 모아서 동아리의 지출 금액을 세고 있고, 재민이는 재현이가 부르는 액수를 순서대로 적고 있다.
    재현이는 가끔 잘못된 수를 부르는 실수를 하는데, 이 때마다 0을 외쳐서, 가장 최근에 재민이가 쓰고 지우지 않았던 수를 지우게 시킨다.
    재현이가 모든 수를 부른 후 재민이가 받아 적은 수의 합은 무엇일까?
 */

public class Solution_swea8931 {                    //제로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int sum = 0;
            int k = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < k; i++){
                int num = Integer.parseInt(br.readLine());

                if(num != 0) {
                    stack.push(num);
                }
                else {
                    stack.pop();
                }
            }

            for(int num : stack){
                sum += num;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
