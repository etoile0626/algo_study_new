package SWEA;

/*
    지하 터널 지도와 맨홀 뚜껑의 위치, 경과된 시간이 주어질 때 탈주범이 위치할 수 있는 장소의 개수를 구하기.
    *탈주범은 시간당 1의 거리를 움직일 수 있다.
    * 1 = +모양, 2 = | 모양, 3 = - 모양, 4 = ㄴ 모양, 5 = 「 모양, 6 = ㄱ 모양, 7 = 」 모양, 0이 있는 자리는 터널이 없음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_swea1953 {                                //[모의 SW 역량테스트] 탈주범 검거
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dir = {
            {},																				//0
            {0, 1, 2, 3},																	//1
            {0, 1},																			//2
            {2, 3},																			//3
            {0, 3},																			//4
            {1, 3},																			//5
            {1, 2},																			//6
            {0, 2}																			//7
    };
    static int[] oppsite = {1, 0, 3, 2};											//하, 상, 좌, 우. 다음 위치를 기준으로 현재 위치와 터널 방향이 맞는지 확인.
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;

    public static void bfs(int r, int c, int l){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {r, c, 1});
        visit[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int i = tmp[0];
            int j = tmp[1];

            if(tmp[2] == l){
                continue;
            }

            for(int d : dir[arr[i][j]]){															//터널 모양에 맞는 방향으로 이동
                int ni = i + dx[d];
                int nj = j + dy[d];

                if(0 <= ni&&ni < n && 0 <= nj&&nj < m && !visit[ni][nj]){
                    boolean flag = false;
                    for(int nd : dir[arr[ni][nj]]){
                        if(nd == oppsite[d]){												//다음위치와 현재 위치의 터널 방향이 맞으면
                            flag = true;
                            break;
                        }
                    }

                    if(flag){
                        q.offer(new int[] {ni, nj, tmp[2] + 1});
                        visit[ni][nj] = true;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visit = new boolean[n][m];

            int cnt = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < m; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(r, c, l);

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(visit[i][j]){
                        cnt++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
