package SWEA;

/*
    회사에서 출발하여 냉장고 배달을 위해 N명의 고객을 방문하고 자신의 집에 돌아가려함.
    *두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산
    *회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다.
    회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때,
    회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾아 이동거리 출력하기.
    *가장 짧은 경로의 이동거리만 밝히면 된다. 이 문제는 가장 짧은 경로를 ‘효율적으로’ 찾는 것이 목적이 아니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1247 {                            //[S/W 문제해결 응용] 3일차 - 최적 경로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n+2][2];                      //0-회사 좌표, 1-집 좌표
            int dist = 0;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n+2; i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }



            sb.append("#").append(T).append(" ").append(dist).append("\n");
        }

        System.out.println(sb.toString());
    }
}
