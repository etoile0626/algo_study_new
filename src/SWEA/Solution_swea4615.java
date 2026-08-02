package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   4x4, 6x6, 8x8(가로, 세로 길이) 크기 보드
   정가운데에 wb/bw로 배치하고 시작한다.
   1. 흑, 백이 번갈아가며 돌을 놓는다.(흑 선)
   2. 자신이 놓을 돌과 자신의 돌 사이에 상대편의 돌이 있을 경우에만 그 곳에 돌을 놓을 수 있고, 그 때의 상대편의 돌은 자신의 돌로 만들 수 있다.
   3. 만약 돌을 놓을 곳이 없다면 상대편 플레이어가 다시 돌을 놓는다.
   4. 보드에 빈 곳이 없거나 양 플레이어 모두 돌을 놓을 곳이 없으면 게임이 끝나고 그 때 보드에 있는 돌의 개수가 많은 플레이어가 승리하게 된다.
   1이면 흑돌, 2이면 백돌이다.
   게임이 끝난 후 보드 위의 흑돌, 백돌의 개수를 출력하기!
   *돌을 놓을 수 없는 곳은 입력으로 주어지지 않는다.
 */

public class Solution_swea4615 {                        //재미있는 오셀로 게임
    //move함수 다시 만들어보기
    static int n;
    static int[][] arr;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static void move(int x, int y, int stone){
        int opponent = 1;                           //지금 놓을 돌과 반대되는 색
        if(stone == 1){
            opponent = 2;
        }

        arr[x][y] = stone;                              //돌 놓기

        //8방향 검사
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            //범위를 벗어나거나 다른 색 돌을 못만나면 해당 방향 검증 멈추기
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != opponent) {
                continue;
            }

            //지금 놓은 돌과 같은 색 돌 만날때까지 이동
            while (0 <= nx&& nx < n && 0 <= ny&& ny < n && arr[nx][ny] == opponent) {
                nx += dx[d];
                ny += dy[d];
            }

            //쭉 이동해서 같은 색 돌을 만났다면
            if (0 <= nx&& nx < n && 0 <= ny&& ny < n && arr[nx][ny] == stone) {
                //처음 놓은 돌 다음 위치부터
                nx = x + dx[d];
                ny = y + dy[d];

                //같은 색 돌 만날때까지 이동하며 같은 색 돌로 바꿔주기
                while (arr[nx][ny] == opponent) {
                    arr[nx][ny] = stone;
                    nx += dx[d];
                    ny += dy[d];
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
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int black = 0;
            int white = 0;
            arr = new int[n][n];

            //오셀로 초기화
            arr[n/2 - 1][n/2 - 1] = 2;
            arr[n/2 - 1][n/2] = 1;
            arr[n/2][n/2 - 1] = 1;
            arr[n/2][n/2] = 2;

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int stone = Integer.parseInt(st.nextToken());           //1-흑돌 2-백돌

                move(x, y, stone);
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 1){
                        black++;
                    } else if(arr[i][j] == 2){
                        white++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(black).append(" ").append(white).append("\n");
        }

        System.out.println(sb.toString());
    }
}
