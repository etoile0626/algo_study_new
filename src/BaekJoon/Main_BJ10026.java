package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
    n*n개의 칸에 R, G, B 중 하나를 넣어 칠하고자 함
    그림은 같은 색으로 이루어진 몇 개의 구역으로 나누어짐 (같은 색상이 상하좌우에 인접해 있는 경우 같은 구역으로 취급)
    ***색상의 차이를 느끼지 못하는 경우에도 같은 색상으로 취급!!!!
    그림이 주어질 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하기
    1 <= n <= 100, 출력은 공백으로 구분해 출력
 */

public class Main_BJ10026 {                     //적록색약

    static int n, cnt1, cnt2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] arr;
    static boolean[][] visited;

    static void bfs(int i, int j, boolean flag){
        if(visited[i][j]){
            return;
        }

        visited[i][j] = true;
        char color = arr[i][j];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});

        while(!q.isEmpty()) {
            int[] ij = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = dx[d] + ij[0];
                int nj = dy[d] + ij[1];

                if (0 <= ni && ni < n && 0 <= nj && nj < n && !visited[ni][nj]) {
                    if(flag) {                                          //적록색약인 경우
                        if (color != 'B' && arr[ni][nj] != 'B'){
                            visited[ni][nj] = true;
                            q.offer(new int[]{ni, nj});
                        } else if (color == 'B' && arr[ni][nj] == 'B'){
                            visited[ni][nj] = true;
                            q.offer(new int[]{ni, nj});
                        }
                    }

                    else{                                             //적록색약이 아닌 경우
                        if (color == arr[ni][nj]) {
                            visited[ni][nj] = true;
                            q.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
        }

        if(!flag){                       //적록색약이 아닌 경우
            cnt1++;
        } else{                         //적록색약인 경우
            cnt2++;
        }
    }

    private static void initVisited() {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String tmp = br.readLine();

            for(int j = 0; j < tmp.length(); j++){
                arr[i][j] = tmp.charAt(j);
            }
        }


        cnt1 = 0;                               //적록색약이 아닌 사람의 구역 수
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bfs(i, j, false);            //적록색약이 아닌 사람
            }
        }

        initVisited();

        cnt2 = 0;                               //적록색약인 사람의 구역 수
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bfs(i, j, true);           //적록색약인 사람
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }
}
