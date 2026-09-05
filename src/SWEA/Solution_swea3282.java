package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N(1≤N≤100)개의 물건과 최대 K(1≤K≤1000) 부피만큼을 넣을 수 있는 가방이 있다.
    1번 물건부터 N번 물건 각각은 부피  Vi와 가치 Ci 를 가지고 있다. (1≤Vi, Ci≤100)
    민수는 물건들 중 몇 개를 선택하여 가방에 넣어서 그 가치의 합을 최대화하기.
    *단, 선택한 물건들의 부피 합이 K 이하여야 한다.
 */

public class Solution_swea3282 {                    //0/1 Knapsack
    //배낭 문제 더 공부하기, 다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] v = new int[n+1];
            int[] c = new int[n+1];
            int[] dp = new int[k+1];                            //i무게 일때 최대 가치

            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){                                //i번째 물건에 대해서
                for(int j = k; j >= v[i]; j--){                         //k무게일때부터 v[i]를 택하기 전과의 가치 중 더 큰 쪽 선택? / 같은 물건을 하나만 쓰기 위해 역순으로
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + c[i]);       //안고른다 / 고른다
                }
            }

            sb.append("#").append(t).append(" ").append(dp[k]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
