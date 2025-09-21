package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    N개중  M개를 골라 출력하기
    *고른 수열은 비내림차순, 중복되는 수열은 한 번만, 사전이 증가하는 순서로 출력
 */

public class Main_BJ15664 {                         //N과 M (10)

    static int n, m;
    static int[] arr, tmp;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int cnt, int idx){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        int prev = -1;
        for(int i = idx; i < n; i++){                       //내림차순 유지를 위해 idx 부터 시작
            if(!visited[i] && arr[i] != prev) {
                visited[i] = true;
                tmp[cnt] = arr[i];
                dfs(cnt + 1, i + 1);                //i번째를 채택했으므로 i + 1부터 탐색
                visited[i] = false;
                prev = arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

        System.out.println(sb.toString());
    }
}
