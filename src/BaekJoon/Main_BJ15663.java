package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개의 수에서 아래 조건을 만족하는 길이가 m인 수열 모두 구하기
    *n개의 자연수 중에서 m개를 고른 수열
    *중복되는 수열을 여러 번 출력하면 안됨
 */

public class Main_BJ15663 {                             //N과 M (9)

    static int n, m;
    static int[] arr, tmp;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int cnt){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        int prev = -1;   // 같은 depth에서 이미 사용한 숫자 기록
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] != prev) {
                visited[i] = true;
                tmp[cnt] = arr[i];
                dfs(cnt + 1);
                visited[i] = false;
                prev = arr[i];   // 이번 depth에서 중복 방지
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
        dfs(0);

        System.out.println(sb.toString());
    }
}
