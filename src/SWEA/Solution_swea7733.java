package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    이치즈는 특이하게도 N*N개의 모든 칸의 맛있는 정도가 동일하지 않다.
    맛있는 정도는 1부터 100 사이로 표현된다.
    요정은 100일동안 치즈를 갉아먹는데, X번째날에는 맛있는 정도가 X인 칸을 먹어버린다.
    치즈 덩어리란상, 하, 좌, 우로인접한 칸들을 하나로 묶어놓은 것을 의미한다.
    100일 중에서 치즈덩어리가 가장 많을 때의 덩어리 개수를 구하는 프로그램을 작성하라.
 */

public class Solution_swea7733 {                    //치즈 도둑
    //다시 풀기
    static int n, count;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static void dfs(int i, int j){
        visit[i][j] = true;

        for(int d = 0; d < 4; d++){
            int ni = dx[d] + i;
            int nj = dy[d] + j;

            if(0 <= ni&&ni < n && 0 <= nj&&nj < n && !visit[ni][nj]){
                dfs(ni, nj);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            int max = 0;
            int cnt = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, arr[i][j]);
                }
            }

            for(int num = 0; num <= max; num++){
                visit = new boolean[n][n];
                count = 0;

                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(arr[i][j] <= num){
                            visit[i][j] = true;
                        }
                    }
                }

                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(!visit[i][j]){
                            dfs(i, j);
                            count++;
                        }
                    }
                }

                cnt = Math.max(cnt, count);
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
