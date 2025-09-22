package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개의 자연수 중에서 m개를 고른 수열을 모두 출력
    *같은 수를 여러번 골라도 됨
    *중복되는 수열은 한 번만, 사전 순으로 증가하도록 출력
 */

public class Main_BJ15665 {                             //N과 M (11)

    static int n, m;
    static int[] arr, tmp;
    static StringBuilder sb;

    static void dfs(int cnt){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        int prev = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] != prev) {
                tmp[cnt] = arr[i];
                dfs(cnt + 1);
                prev = tmp[cnt];
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

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb.toString());
    }
}
