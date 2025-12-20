package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    한수가 캠프를 마치고 집으로 가려고 함. 집은 오른쪽 위, 한수는 왼쪽 위에 있음
    .은 갈 수 있는 칸, T는 가지못하는 칸
    r * c 맵과 거리 k가 주어진다면 한수가 집까지 도착하는 경우 중 거리가 k인 가짓수를 구하기
 */

public class Main_BJ1189 {                  //컴백홈

    static int r, c, k, count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] arr;
    static boolean[][] visit;

    static void dfs(int x, int y, int cnt){
        if((x == 0 && y == c-1)){
            if(cnt == k){
                count++;
            }

            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0 <= nx&&nx < r && 0 <= ny&&ny < c && !visit[nx][ny] && arr[nx][ny] == '.'){
                visit[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visit[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();

            for(int j = 0; j < c; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        count = 0;
        visit[r-1][0] = true;
        dfs(r-1, 0, 1);                 //시작칸도 거리에 포함

        System.out.println(count);
    }
}
