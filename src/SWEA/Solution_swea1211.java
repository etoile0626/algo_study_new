package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    100 x 100 크기의 2차원 배열로 주어진 사다리에 대해서,
    모든 출발점을 검사하여 바닥까지 가장 짧은 이동 거리를 갖는 시작점 x(복수 개인 경우 가장 큰 x좌표)를 반환하는 코드를 작성하라.
    *(‘0’으로 채워진 평면상에 사다리는 연속된 ‘1’로 표현된다.)
    *아래 방향으로 진행하면서 좌우 방향으로 이동 가능한 통로가 나타나면 방향 전환을 하게 된다.
 */

public class Solution_swea1211 {                    //[S/W 문제해결 기본] 2일차 - Ladder2
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int T = 1; T <= 10; T++){
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 100; i++){
                if(arr[0][i] != 1) {
                    continue;
                }

                int x = 0;
                int y = i;
                int dist = 0;

                while (x < 99){
                    if(0 <= (y-1)&&(y-1) < 100 && arr[x][y-1] == 1){
                        while (0 <= (y-1)&&(y-1) < 100 && arr[x][y-1] == 1){
                            y--;
                            dist++;
                        }
                    }
                    else if(0 <= (y+1)&&(y+1) < 100 && arr[x][y+1] == 1){
                        while (0 <= (y+1)&&(y+1) < 100 && arr[x][y+1] == 1){
                            y++;
                            dist++;
                        }
                    }

                    x++;
                    dist++;
                }

                if(dist <= min){
                    min = dist;
                    idx = i;
                }
            }

            sb.append("#").append(t).append(" ").append(idx).append("\n");
        }

        System.out.println(sb.toString());
    }
}
