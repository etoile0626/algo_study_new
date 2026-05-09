package SWEA;

/*
    등산로를 만드는 규칙은 다음과 같다.
   ① 등산로는 가장 높은 봉우리에서 시작해야 한다.
   ② 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
       즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다.
   ③ 긴 등산로를 만들기 위해 "딱 한 곳"을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
   이때 만들 수 있는 가장 긴 등산로를 찾아 그 길이를 출력하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1949 {                    //[모의 SW 역량테스트] 등산로 조성
    //다시 풀기
    static int n, k, len;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visit;

    public static void dfs(int i, int j, int cnt, boolean cut){
        len = Math.max(len, cnt);

        for(int d = 0; d < 4; d++){
            int ni = i + dx[d];
            int nj = j + dy[d];

            if(0 <= ni&&ni < n && 0 <= nj&&nj < n && !visit[ni][nj]){
                if(arr[ni][nj] >= arr[i][j]){       //다음 값이 더 크다면
                    if(!cut && arr[ni][nj] - k < arr[i][j]){
                        int tmp = arr[ni][nj];
                        arr[ni][nj] = arr[i][j] - 1;
                        visit[ni][nj] = true;

                        dfs(ni, nj, cnt + 1, true);

                        visit[ni][nj] = false;
                        arr[ni][nj] = tmp;

                    }
                } else{                             //다음 값이 작으면 속행
                    visit[ni][nj] = true;
                    dfs(ni, nj, cnt + 1, cut);
                    visit[ni][nj] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            visit = new boolean[n][n];
            len = 0;                                            //최대 등산로 길이
            int max = 0;                                        //최고점 값

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, arr[i][j]);
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == max){
                        visit[i][j] = true;
                        dfs(i, j, 1, false);
                        visit[i][j] = false;
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(len).append("\n");
        }

        System.out.println(sb.toString());
    }
}
