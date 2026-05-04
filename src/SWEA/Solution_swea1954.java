package SWEA;

/*
    달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
    다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.
    *1 ≤ N ≤ 10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_swea1954 {                //달팽이 숫자
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};            //우하좌상 순서로
    static boolean[][] visit;
    static int[][] arr;
    static int n, num;

    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});           //좌표 + 방향(0-우/1-하/2-좌/3-상)
        visit[0][0] = true;

        while (!q.isEmpty()){
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            int d = ij[2];

            arr[i][j] = num++;

            int ni = i + dx[d];
            int nj = j + dy[d];

            //쭉 직진하다 벽이나 이미 지나간 곳 만나면 꺾기
            if (ni < 0 || ni >= n || nj < 0 || nj >= n || visit[ni][nj]) {
                d = (d + 1) % 4;   // 우 하 좌 상 우 순환
                ni = i + dx[d];
                nj = j + dy[d];
            }

            if(ni >= 0 && ni < n && nj >= 0 && !visit[ni][nj]) {
                q.offer(new int[]{ni, nj, d});
                visit[ni][nj] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visit = new boolean[n][n];

            num = 1;
            bfs();

            sb.append("#").append(T).append("\n");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
