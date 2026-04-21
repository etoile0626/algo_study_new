package BaekJoon;

/*
    .은 빈 공간, #은 울타리, o는 양, v는 늑대.
    한 칸에서 수직, 수평으로 이동 가능, 울타리로 막히지 않고 그냥 이동 가능하다면 두 칸은 같은 영역 취급.
    *마당에서 탈출할 수 있는 칸은 어느 영역으로도 취급 받지 않음.()
    한 영역에서 양이 늑대보다 더 많으면 승리, 그렇지 않으면 늑대에게 먹힘.
    *맨처음 양과 늑대는 마당 안 영역에 존재.
    살아남은 양과 늑대의 수를 출력하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Bj3184 {                                              //양
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int r, c, sheep, wolf;
    static char[][] arr;
    static boolean[][] visit;

    static void bfs(int r, int c){
        int s = 0;                      //이번 탐색에서 양의 수
        int w = 0;                      //이번 탐색에서 늑대의 수

        if(arr[r][c] == 'v'){
            w++;
        } else if(arr[r][c] == 'o'){
            s++;
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
        visit[r][c] = true;

        while(!q.isEmpty()){
            int[] ij = q.poll();

            for(int d = 0; d < 4; d++){
                int ni = ij[0] + dx[d];
                int nj = ij[1] + dy[d];

                if(!visit[ni][nj]) {
                    if (arr[ni][nj] == '#') {
                        continue;
                    } else if (arr[ni][nj] == 'o') {
                        s++;
                    } else if(arr[ni][nj] == 'v'){
                        w++;
                    }

                    q.offer(new int[]{ni, nj});
                    visit[ni][nj] = true;
                }
            }
        }

        //이번 탐색에서 더 많았던 동물을 구하기
        if(s > w){
            sheep += s;
        } else{
            wolf += w;
        }

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visit = new boolean[r][c];
        sheep = 0;
        wolf = 0;

        for(int i = 0; i < r; i++){
            String tmp = br.readLine();

            for(int j = 0; j < c; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!visit[i][j] && (arr[i][j] == 'v' || arr[i][j] == 'o')){
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }
}
