package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
    nXn 크기의 표 각 칸에는 지뢰가 있을 수도 있고 없을 수도 있다.
    지뢰가 없는 칸이라면 변이 맞닿아 있거나 꼭지점이 맞닿아 있는 최대 8칸에 대해 몇 개의 지뢰가 있는지가 0에서 8사이의 숫자로 클릭한 칸에 표시
    숫자가 0이라면 근처의 8방향에 지뢰가 없다는 것이 확정된 것이기 때문에 그 8방향의 칸도 자동으로 숫자를 표시
    지뢰를 ‘*’로, 지뢰가 없는 칸을 ‘.’로, 클릭한 지뢰가 없는 칸을 ‘c’로 나타냄.
    표의 크기와 표가 주어질 때, 지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자들이 표시되려면 최소 몇 번의 클릭을 해야 하는지 구하기.
    * ‘*’와 ‘.’외의 다른 문자는 입력으로 주어지지 않는다.
 */

public class Solution_swea1868 {                //파핑파핑 지뢰찾기
    //  다시 풀기
    static int n;
    static int[][] mine;
    static char[][] arr;
    static boolean[][] visit;

    private static void bfs(int i, int j){
        visit[i][j] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});

        while (!q.isEmpty()){
            int[] ij = q.poll();
            int x = ij[0];
            int y = ij[1];

            if(mine[x][y] != 0){            //숫자칸을 만나면 확장 없음
                continue;
            }

            //주변에 지뢰가 없으면 큐에 넣어 확장처리
            for(int k = x-1; k <= x+1; k++){
                for(int l = y-1; l <= y+1; l++) {
                    //범위 밖은 무시
                    if (k < 0 || k >= n || l < 0 || l >= n) {
                        continue;
                    }

                    //지뢰 칸이나 이미 방문한 칸도 무시
                    if(arr[k][l] == '*' || visit[k][l]){
                        continue;
                    }

                    visit[k][l] = true;
                    q.offer(new int[] {k, l});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            mine = new int[n][n];                       //미리 정답지 만들기(주변 지뢰갯수 카운팅)
            visit = new boolean[n][n];
            int crick = 0;

            for(int i = 0; i < n; i++){
                String str = br.readLine();
                for(int j = 0; j < n; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == '.'){
                        //i, j 위치 주변의 지뢰 갯수 카운팅
                        int m = 0;

                        for(int k = i-1; k <= i+1; k++){
                            for(int l = j-1; l <= j+1; l++){
                                if(k < 0 || k >= n || l < 0 || l >= n){
                                    continue;
                                }

                                if(arr[k][l] == '*'){
                                    m++;
                                }
                            }
                        }

                        mine[i][j] = m;
                    } else{
                        mine[i][j] = Integer.MAX_VALUE;                     //지뢰
                    }
                }
            }

            //bfs를 통해 0이 모인 영역들 클릭하기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(mine[i][j] == 0 && !visit[i][j]){            //mine이 0인 곳을 눌러야 최대한 많은 칸을 먹을 수 있음
                        bfs(i, j);
                        crick++;
                    }
                }
            }

            //bfs이후 남은 영역 처리
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == '.' && !visit[i][j]){            //여기까지 왔는데 빈칸이 있는거면 일일히 클릭해줘야하는 애들
                        crick++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(crick).append("\n");
        }

        System.out.println(sb.toString());
    }
}
