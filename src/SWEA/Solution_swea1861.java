package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    당신이 어떤 방에 있다면, 상하좌우에 있는 다른 방으로 이동할 수 있다.
    물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 '정확히 1' 더 커야 한다.
    처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하기.
    *처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지를 공백으로 구분하여 출력
    *이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력
 */

public class Solution_swea1861 {                        //정사각형 방
    //다시 풀기

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int[][] arr;
    static boolean[][] visit;

    private static int dfs(int i , int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        int dist = 1;                                           //시작점도 포함

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int x = ij[0];
            int y = ij[1];

            for(int d = 0; d < 4; d++){
                int ni = x + dx[d];
                int nj = y + dy[d];

                if(0 <= ni&&ni < n && 0 <= nj&&nj < n && !visit[ni][nj]){
                    if(arr[ni][nj] - arr[x][y] == 1){
                        visit[ni][nj] = true;
                        q.offer(new int[] {ni, nj});
                        dist++;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n  = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            int start = 0;
            int max = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    visit = new boolean[n][n];
                    visit[i][j] = true;
                    int dist = dfs(i, j);

                    if(dist > max){
                        max = dist;
                        start = arr[i][j];
                    } else if (dist > 0 && dist == max){
                        start = Math.min(start, arr[i][j]);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(start).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
