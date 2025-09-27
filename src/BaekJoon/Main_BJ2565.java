package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    전봇대 a와 b 사이에 존재하는 전깃줄을 없애 전깃줄이 교차하지 않도록 만들고자 함.
    남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해서 없애야 하는 전깃줄의 최소 개수 구하기
    *같은 위치에 두 개 이상의 전깃줄이 연결될 수 없음.
    *위치는 1~500

    =>전깃줄의 최소 개수 = 전체 전깃줄 - 교차하지 않고 설치 가능한 전깃줄의 최대 갯수?
 */

public class Main_BJ2565 {                                      //전깃줄
    /*다시 풀기*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());            //총 전깃줄 개수

        int[][] wire = new int[n+1][2];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a_idx = Integer.parseInt(st.nextToken());
            int b_idx = Integer.parseInt(st.nextToken());

            wire[i][0] = a_idx;                                          //a 전봇대
            wire[i][1] = b_idx;                                          //b 전봇대
        }

        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);           //a 전봇대 값 기준으로 정렬

        int[] dp = new int[n+1];                                          //i번째 전깃줄을 마지막으로 이었을때 설치 가능한 전깃줄의 최대 갯수

        for(int i = 1; i <= n; i++){
             dp[i] = 1;                                                   //설치 가능한 전깃줄의 최대갯수를 최솟값 1로 초기화

            for(int j = 1; j < i; j++){
                if(wire[i][1] > wire[j][1]){                              //i번째 전깃줄보다 j번째 전깃줄이 위에 있다면 (꼬이지 않고 설치 되어있다면)
                    dp[i] = Math.max(dp[i], dp[j] + 1);                   //최댓값 갱신
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, dp[i]);                                 //dp 값중 최댓값 탐색
        }
        System.out.println(n - max);                                    //제거해야할 전깃줄 최소 개수 = 전체 - 설치가능한 최대 전깃줄 수
    }
}
