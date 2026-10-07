package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    정우는 그냥 (x1, y1)에서 (x2, y2)로 이동하는 것은 재미가 없다고 생각한다.
    그래서 이전 이동이 가로 이동이었다면, 이번에는 세로 이동으로 이동하고,
    이전 이동이 세로 이동이었다면, 이번에는 가로 이동으로 이동하여 (x1, y1)에서 (x2, y2)로 이동하려고 한다.
    *가장 첫 이동은 어떤 이동 이어도 상관 없다.
    이 때, 최소 몇 번의 이동을 해야 (x1, y1)에서 (x2, y2)로 이동할 수 있는지 구하기.
 */

public class Solution_swea8382 {                                    //방향 전환
    //다시 풀까
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int x1, x2, y1, y2, min;
    static boolean[][][] visit;
    static final int OFFSET = 101;

    private static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x1, y1, 0, 0});                  //세로이동부터
        q.offer(new int[] {x1, y1, 0, 1});                  //가로이동부터
        visit[x1][y1][0] = true;
        visit[x1][y1][1] = true;

        while (!q.isEmpty()){
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int cnt = xy[2];
            int flag = xy[3];

            if(x == x2 && y == y2){
                min = Math.min(min, cnt);
                break;
            }

            if(flag == 0){
                for(int d = 0; d < 4; d+=2){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(0 <= nx&&nx < 202 && 0 <= ny&&ny < 202 && !visit[nx][ny][1]) {
                        q.offer(new int[]{nx, ny, cnt + 1, 1});
                        visit[nx][ny][1] = true;
                    }
                }
            } else{
                for(int d = 1; d < 4; d+=2){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(0 <= nx&&nx < 202 && 0 <= ny&&ny < 202 && !visit[nx][ny][0]) {
                        q.offer(new int[]{nx, ny, cnt + 1, 0});
                        visit[nx][ny][0] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) + OFFSET;                 //visit 배열에 음수 못 넣어서
            y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            y2 = Integer.parseInt(st.nextToken()) + OFFSET;
            min = Integer.MAX_VALUE;
            visit = new boolean[202][202][2];       //-100~100사이 범위이므로

            bfs();

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
