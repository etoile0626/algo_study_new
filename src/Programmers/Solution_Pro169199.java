package Programmers;

/*
    리코쳇 로봇이라는 보드게임 존재
    = 시작위치에서 출발한 뒤 목표 위치에 정확하게 멈추기 위해 최소 몇 번 이동해야하는지 구하는 게임
    이동은 상하좌우 어느 한 방향으로 장애물이나 벽에 부딪힐때까지 이동
    "."은 빈 공간, "R"은 로봇의 처음 위치, "D"는 장애물의 위치, "G"는 목표지점
    만약 도달 불가능한 경우 -1 출력
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_Pro169199 {                       //리코쳇 로봇
    class Solution {
        public int dfs(String[]board, int x, int y){
            Queue<int[]> q = new ArrayDeque<>();
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            int cnt = 0;

            int n = board.length;
            int m = board[0].length();
            boolean[][] visit = new boolean[n][m];

            q.offer(new int[] {x, y, 0});
            visit[x][y] = true;

            while(!q.isEmpty()){
                int[] ij = q.poll();
                int i = ij[0];
                int j = ij[1];
                int count = ij[2];

                if(board[i].charAt(j) == 'G'){
                    cnt = count;
                    break;
                }

                for(int d = 0; d < 4; d++){
                    int di = i;
                    int dj = j;
                    //벽이나 장애물 만날때까지
                    while(0 <= di&&di < n && 0 <= dj&&dj < m && board[di].charAt(dj) != 'D'){
                        di += dx[d];
                        dj += dy[d];
                    }
                    //부딪힌 직전 위치로
                    di -= dx[d];
                    dj -= dy[d];

                    if(!visit[di][dj]){
                        visit[di][dj] = true;
                        q.offer(new int[] {di, dj, count+1});
                    }
                }
            }

            if(cnt == 0){
                return -1;
            } else{
                return cnt;
            }
        }

        public int solution(String[] board) {
            int answer = 0;
            int n = board.length;
            int m = board[0].length();
            int x = 0;
            int y = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i].charAt(j) == 'R'){
                        x = i;
                        y = j;
                    }
                }
            }

            answer = dfs(board, x, y);

            return answer;
        }
    }
}
