package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    어떤 모임에서 각 회원은 다른 회원들과 가까운 정도에 따라 점수를 부여
    다른 모든 회원과 친구인 경우 = 1점
    다른 모든 회원이 친구거나 친구의 친구인 경우 = 2점
    친구거나 친구의 친구거나 친구의 친구의 친구인 경우 = 3점 ( 대충 가중치 느낌 )
    * 두 회원이 친구 사이이면 서 친구의 친구사이이면, 친구사이로 봄 (점수가 낮은 조건을 만족하면 그 쪽으로 판단)
    회장의 점수는 회원들 중 점수가 가장 낮은 사람, 회장의 점수와 회장이 될 수 있는 사람 모두 구하기
    * n < 50
 */

public class Main_BJ2660 {                              //회장뽑기

    static int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = INF;

                if(i == j){
                    arr[i][j] = 0;
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(n1 == -1 && n2 == -1){
                break;
            }

            arr[n1][n2] = 1;
            arr[n2][n1] = 1;
        }

        //플로이드 워셜
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        int min = INF;                              //회장이 되기 위한 최소 점수
        int[] member = new int[n+1];                //회원들의 점수 배열
        for(int i = 1; i <= n; i++){
            int max = 0;                            //회원의 점수 계산
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == INF){
                    continue;
                }
                max = Math.max(max, arr[i][j]);
            }
            member[i] = max;
            min = Math.min(min, member[i]);
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(member[i] == min){
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
        for(int i = 1; i <= n; i++){
            if(member[i] == min){
                System.out.print(i + " ");
            }
        }
    }
}
