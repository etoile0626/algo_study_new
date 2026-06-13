package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_swea1226 {                                //[S/W 문제해결 기본] 7일차 - 미로1
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int goal;
    static int[][] arr;
    static boolean[][] visit;

    static void bfs(int cnt){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 1});
        visit[1][1] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            if(arr[x][y] == 3){
                goal = 1;
                break;
            }

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0 <= nx&&nx < 16 && 0 <= ny&&ny < 16 && !visit[nx][ny]){
                    if(arr[nx][ny] != 1){
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for(int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());
            arr = new int[16][16];
            visit = new boolean[16][16];
            goal = 0;

            for(int i = 0; i < 16; i++){
                String str = br.readLine();

                for(int j = 0; j < 16; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            bfs(0);

            sb.append("#").append(T).append(" ").append(goal).append("\n");
        }

        System.out.println(sb.toString());
    }
}
