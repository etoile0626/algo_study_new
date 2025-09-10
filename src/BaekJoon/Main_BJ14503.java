package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    로봇 청소기와 방의 상태(n*m)가 주어질 때, 청소하는 영역의 개수를 구하기
    *좌표 (r, c) r+1번째 줄에 있는 c+1번째 칸
    1. 현재 칸이 청소되어 있지 않으면 현재 칸을 청소
    2. 현재 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
        2-1. 바라보는 방향을 유지한채로 한 칸 후진 후 1번으로
        2-1. 후진 할 수 없으면 동작 중지
    3. 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
        3-1. 반시계 방향으로 90도 회전
        3-2. 바라보는 방향 앞 한 칸이 청소되지 않았으면 청소
        3-3. 1번으로
    * 0 = 청소되지 않은 칸, 1 = 벽 ((i, j) 좌표의 상태)
    * 0 = 북, 1 = 동, 2 = 남, 3 = 서 (방향 d)
    * 3 <= n, m <= 50
 */

public class Main_BJ14503 {                         //로봇 청소기

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true){
            if(arr[r][c] == 0){
                arr[r][c] = 2;                              //청소됨 = 2
                cnt++;
            }

            boolean flag = true;                            //true = 주변 청소가 전부 됨, false = 주변 청소가 안 됨
            for(int i = 0; i < 4; i++){
                if((0 <= r + dx[i]&&r + dx[i] < n && 0 <= c + dy[i]&&c + dy[i] < m) && arr[r+dx[i]][c+dy[i]] == 0){             //하나라도 주변 청소가 안되었으면 false로 만들기
                    flag = false;
                    break;
                }
            }

            if(flag){                                       // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                if((0 <= r - dx[d]&&r - dx[d] < n && 0 <= c - dy[d]&&c - dy[d] < m) && arr[r-dx[d]][c-dy[d]] != 1){             //한 칸 후진할 수 있다면
                    r = r - dx[d];
                    c = c - dy[d];
                } else{
                    break;
                }
            } else {                                        // 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                //반 시계로 90도 돌리기
                if (d == 0) {
                    d = 3;
                } else {
                    d = d - 1;
                }

                // 앞쪽 칸이 청소되지 않은 빈 칸인 경우
                if((0 <= r + dx[d]&&r + dx[d] < n && 0 <= c + dy[d]&&c + dy[d] < m) && arr[r+dx[d]][c+dy[d]] == 0){
                    r = r + dx[d];
                    c = c + dy[d];
                }
            }
        }

        System.out.println(cnt);
    }
}
