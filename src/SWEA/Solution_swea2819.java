package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
    4×4 크기의 격자판이 있다. 격자판의 각 격자칸에는 0부터 9 사이의 숫자가 적혀 있다.
    격자판의 임의의 위치에서 시작해서, 동서남북 네 방향으로 인접한 격자로 총 여섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례대로 이어 붙이면 7자리의 수가 된다.
    이동을 할 때에는 한 번 거쳤던 격자칸을 다시 거쳐도 되며, 0으로 시작하는 0102001과 같은 수를 만들 수도 있다.
    만들 수 있는 서로 다른 일곱 자리 수들의 개수를 구하기.
 */

public class Solution_swea2819 {                        //격자판의 숫자 이어 붙이기
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[][] arr;
    static Set<String> set;

    private static void dfs(int x, int y, int cnt, String str){
        if(cnt == 7){
            set.add(str);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0 <= nx&&nx < 4 && 0 <= ny&&ny < 4){
                dfs(nx, ny, cnt+1, str+arr[nx][ny]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            arr = new String[4][4];
            set = new HashSet<>();

            for(int i = 0; i < 4; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 4; j++){
                    arr[i][j] = st.nextToken();
                }
            }

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    dfs(i, j, 1, arr[i][j]);
                }
            }

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
