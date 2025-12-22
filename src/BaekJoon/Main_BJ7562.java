package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    나이트가 이동하고자 하는 칸이 주어질 때, 몇 번 이동해야 해당 칸으로 갈 수 있는가?

 */

public class Main_BJ7562 {                  //나이트의 이동

    static int l, s1, s2, e1, e2;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s1, s2});
        visit[s1][s2] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx&&nx < l && 0 <= ny&&ny < l) {
                    if (!visit[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        arr[nx][ny] = arr[x][y] + 1;
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int T = 0; T < t; T++){
            l = Integer.parseInt(br.readLine());

            arr = new int[l][l];
            visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            e1 = Integer.parseInt(st.nextToken());
            e2 = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(arr[e1][e2]);
        }
    }
}
