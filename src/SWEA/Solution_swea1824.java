package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    프로그램은 현재 위치에 있는 문자가 나타내는 명령을 처리하고, 이동 방향에 따라 다음 문자로 이동해야 한다.
    가장 처음 위치는 제일 왼쪽 위에 있는 문자이고, 이동 방향은 오른쪽이다.
    명령을 처리하다 보면 이동 방향이 상하좌우로 바뀔 수 있다.
    만약 다음 이동이 2차원 격자의 바깥으로 이동하는 방향이면, 반대편에 있는 위치로 이동한다.
    예를 들어, 첫 번째 줄의 가장 오른쪽 칸에서 오른쪽 방향으로 이동하면 첫 번째 줄의 가장 왼쪽 칸으로 이동한다.
    혁셈블리어에서는 메모리가 단 하나 있으며, 0에서 15사이의 정수를 하나 저장할 수 있다. 가장 처음에는 0이 저장되어 있다.
    사용 가능한 명령은 아래와 같다:

    문자	수행 명령
    <	이동 방향을 왼쪽으로 바꾼다.
    >	이동 방향을 오른쪽으로 바꾼다.
    ^	이동 방향을 위쪽으로 바꾼다.
    v	이동 방향을 아래쪽으로 바꾼다.
    _	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
    |	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
    ?	이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
    .	아무 것도 하지 않는다.
    @	프로그램의 실행을 정지한다.
    0~9	메모리에 문자가 나타내는 값을 저장한다.
    +	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
    -	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.
 */

public class Solution_swea1824 {                //혁진이의 프로그램 검증
    //다시 풀기
    static int r;
    static int c;
    static char[][] arr;
    static boolean[][][][] visit;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    static boolean simulation() {
        visit = new boolean[r][c][4][16];           //r*c, 방향, 메모리
        Queue<int[]> q = new ArrayDeque<>();

        // {행, 열, 방향, 메모리값}, 처음 방향은 오른쪽(3)
        q.offer(new int[]{0, 0, 3, 0});
        visit[0][0][3][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int dir = cur[2];
            int memory = cur[3];
            char command = arr[cr][cc];

            if (command == '@') return true;

            if (command == '<') dir = 2;
            else if (command == '>') dir = 3;
            else if (command == '^') dir = 0;
            else if (command == 'v') dir = 1;
            else if (command == '_') dir = memory == 0 ? 3 : 2;
            else if (command == '|') dir = memory == 0 ? 1 : 0;
            else if (command >= '0' && command <= '9') memory = command - '0';
            else if (command == '+') memory = (memory + 1) % 16;
            else if (command == '-') memory = (memory + 15) % 16;

            if (command == '?') {
                for (int d = 0; d < 4; d++) {
                    int nr = (cr + dr[d] + r) % r;
                    int nc = (cc + dc[d] + c) % c;

                    if (!visit[nr][nc][d][memory]) {
                        visit[nr][nc][d][memory] = true;
                        q.offer(new int[]{nr, nc, d, memory});
                    }
                }
            } else {
                int nr = (cr + dr[dir] + r) % r;
                int nc = (cc + dc[dir] + c) % c;

                if (!visit[nr][nc][dir][memory]) {
                    visit[nr][nc][dir][memory] = true;
                    q.offer(new int[]{nr, nc, dir, memory});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new char[r][c];

            for(int i = 0; i < r; i++){
                String tmp = br.readLine();

                for(int j = 0; j < c; j++){
                    arr[i][j] = tmp.charAt(j);
                }
            }

            String str = "";
            boolean flag = simulation();

            if(flag){
                str = "YES";
            } else {
                str = "NO";
            }
            sb.append("#").append(t).append(" ").append(str).append("\n");
        }

        System.out.println(sb.toString());
    }
}
