package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    당신은 3명 이상의 학생으로 구성된 조의 수를 최대화하려고 한다. 각 학생은 정확히 한 개의 조에만 속할 수 있다.
    학생들을 조로 적당히 나누었을 때, 3명 이상의 학생으로 구성된 조의 수의 최댓값이 얼마인지를 구하기.
 */

public class Solution_swea13218 {                           //조별과제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int max = n / 3;

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
