package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
    100*100 행렬의 형태로 만들어진 미로에서 0은 길, 1은 벽
    미로의 시작점은 (1, 1)(=2)이고 도착점은 (13, 13)(=3)이다.
    주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하기.
    *도달 가능 여부를 1 또는 0으로 표시한다 (1 - 가능함, 0 - 가능하지 않음).
 */

public class Solution_swea1227 {                        //[S/W 문제해결 기본] 7일차 - 미로2
    static int flag;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 1});
        visit[1][1] = true;

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int x = ij[0];
            int y = ij[1];

            if(arr[x][y] == 3){
                flag = 1;
                break;
            }

            for(int d = 0; d < 4; d++){
                int ni = x + dx[d];
                int nj = y + dy[d];

                if(0 <= ni&&ni < 100 && 0 <= nj&&nj < 100 && !visit[ni][nj]){
                    if(arr[ni][nj] != 1){
                        visit[ni][nj] = true;
                        q.offer(new int[] {ni, nj});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int T = 0; T < 10; T++){
            int t = Integer.parseInt(br.readLine());
            arr = new int[100][100];
            visit = new boolean[100][100];
            flag = 0;

            for(int i = 0; i < 100; i++){
                String str = br.readLine();

                for(int j = 0; j < 100; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            bfs();

            sb.append("#").append(t).append(" ").append(flag).append("\n");
        }

        System.out.println(sb.toString());
    }
}
