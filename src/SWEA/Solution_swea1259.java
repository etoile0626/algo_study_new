package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    원형 금속 막대는 한 쪽 면에 수나사와 다른 쪽에 암나사로 이루어져 있다. 수나사와 암나사는 굵기가 서로 다르다.
    *나사의 굵기를 수나사의 굵기 x 암나사의 굵기로 표현한다. 연결은 +로 표현.
    수나사의 굵기와 암나사의 굵기가 서로 일치해야 한다. (ex. 3x4+4x5로 연결. / 4x5+3x4로 연결하면 연결되지 않는다.)
    서로 다른 여러 개의 원형 금속 막대를 가장 많이 연결하려고 할 때, 어떤 순서로 연결해야 가장 많이 연결하는지를 찾기.
 */

public class Solution_swea1259 {                    //[S/W 문제해결 응용] 7일차 - 금속막대
    //절대절대 다시풀기
    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int[] path;
    static boolean found;

    public static void dfs(int cnt, int last){          // cnt: 지금까지 연결한 막대 수, last: 마지막 막대의 암나사 굵기
        if(cnt == n){
            found = true;
            return;
        }

        for(int i = 0; i < n; i++){
            if(visit[i] || arr[i][0] != last) {
                continue;
            }

            visit[i] = true;
            path[cnt] = i;
            dfs(cnt + 1, arr[i][1]);
            if(found) {
                return;
            }
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            visit = new boolean[n];
            path = new int[n];
            found = false;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            //모든 나사 하나씩 처음 스타트로 지정해서 맞춰보기
            for(int i = 0; i < n && !found; i++){
                visit[i] = true;
                path[0] = i;
                dfs(1, arr[i][1]);
                if(!found) visit[i] = false;
            }

            sb.append("#").append(t);
            for(int i = 0; i < n; i++){
                sb.append(" ").append(arr[path[i]][0]).append(" ").append(arr[path[i]][1]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
