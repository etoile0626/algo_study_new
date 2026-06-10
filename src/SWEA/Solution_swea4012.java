package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    두 명의 손님에게 최대한 비슷한 맛의 음식을 만들어내려고 함.
    식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다. (N은 짝수이다.)
    A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 함.
    식재료 i는 식재료 j와 같이 요리하게 되면 궁합이 잘 맞아 시너지 Sij 발생, 각 음식의 맛은 음식을 구성하는 식재료들로부터 발생하는 시너지 Sij들의 합.
    가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 두 음식 간의 맛의 차이가 최소가 되는 경우를 찾고 그 최솟값을 구하기.
 */

public class Solution_swea4012 {                                    //[모의 SW 역량테스트] 요리사
    static int n , min;
    static int[][] arr;
    static boolean[] visit;

    private static void dfs(int start, int cnt){
        if(cnt == n/2){
            int a = 0;
            int b = 0;
            for(int i = 1; i <= n; i++){
                for(int j = i + 1; j <= n; j++){
                    if(visit[i] && visit[j]){
                        a += (arr[i][j] + arr[j][i]);
                    } else if(!visit[i] && !visit[j]){
                        b += (arr[i][j] + arr[j][i]);
                    }
                }
            }

            min = Math.min(Math.abs(a - b), min);
            return;
        }

        for(int i = start; i <= n; i++){
            visit[i] = true;
            dfs(i+1, cnt+1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1][n+1];
            visit = new boolean[n+1];                                       //true - a가 선택한 음식, false - b가 선택한 음식
            min = Integer.MAX_VALUE;

            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 1; j <= n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(1, 0);                  //1번 재료부터 선택

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
