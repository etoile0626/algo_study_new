package SWEA;

/*
    한 변의 길이가 N인 정사각형 모양을 가진 지역에 디저트 카페가 모여 있다.
    카페들 사이에는 "대각선 방향"으로 움직일 수 있는 길들이 있다.
    디저트 카페 투어는 어느 한 카페에서 출발하여 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다.
    카페 투어 중에 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안 된다.
    디저트를 가장 많이 먹을 수 있는 경로를 찾고, 그 때의 디저트 수 구하기.
    *디저트를 먹을 수 없는 경우 -1을 출력.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea2105 {                    //[모의 SW 역량테스트] 디저트 카페
    //다시 풀기
    static int n, max, r, c, a, b;
    static int[][] arr;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};                       //대각선 이동
    static boolean[] desertVisit;

    static void dfs(int x, int y, int dir, int step, int cnt) {                 //dir - 방향, steo - 현재 방향에서 몇칸 갔는지, cnt - 디저트 갯수
        if (dir == 4) {
            max = Math.max(max, cnt - 1);           //시작점으로 다시 오면서 세진 횟수는 제외
            return;
        }

        int target = (dir == 0 || dir == 2) ? a : b;

        if (step == target) {                       //a 또는 b(사각형 변의 길이)만큼 도달 시
            dfs(x, y, dir + 1, 0, cnt);
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            return;
        }

        boolean isLastStep = (dir == 3 && step == target - 1);

        int desert = arr[nx][ny];
        if (!isLastStep && desertVisit[desert]) {
            return;
        }

        desertVisit[desert] = true;
        dfs(nx, ny, dir, step + 1, cnt + 1);
        desertVisit[desert] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            max = 0;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    r = i; c = j;
                    for (a = 1; a < n; a++) {
                        for (b = 1; b < n; b++) {
                            desertVisit = new boolean[101];                     //디저트 종류 체크 용
                            desertVisit[arr[i][j]] = true;
                            dfs(i, j, 0, 0, 1);
                        }
                    }
                }
            }

            if(max == 0){
                max = -1;
            }
            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
