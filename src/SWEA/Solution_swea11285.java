package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    보드에는 중심이 원점이고 반지름이 20,40,60,80,100,120,140,160,180,200 (단위는 mm)인 10개의 원이 그려져 있다.
    각각의 화살은 꽂힌 지점을 감싸는 가장 가까운 원(경계선에 꽂힌 경우도 포함)의 반지름이 20 * (11 - p)인 경우 p점을 획득한다. (1 ≤ p ≤ 10)
    *만약 가장 큰 원 바깥에 꽂혔다면 얻는 점수는 없다.
    N 개의 화살을 던진 위치가 주어지면, 총 몇 점을 얻었는지 계산하자.
 */

public class Solution_swea11285 {                               //다트 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int score = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                int x = arr[i][0];
                int y = arr[i][1];
                double dist = Math.sqrt(x*x + y*y);

                for(int p = 10; p >= 1; p--){
                    if(dist <= 20 * (11 - p)){
                        score += p;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(score).append("\n");
        }

        System.out.println(sb.toString());
    }
}
