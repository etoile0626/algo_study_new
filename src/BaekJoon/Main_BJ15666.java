package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개 중 m개를 고른 수열 모두 출력
    *같은 수를 여러번 골라도 됨
    *오름차순으로 고르기
    *중복 수열은 한 번만, 사전 순으로 증가하는 순서로 출력
 */

public class Main_BJ15666 {                     //N과 M (12)

    static int n, m;
    static int[] arr, tmp;
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
        for(int i = idx; i < n; i++){
            if(arr[i] != prev) {
                tmp[cnt] = arr[i];
                dfs(cnt + 1, i);                //다음 탐색에도 idx도 포함시켜 중복 원소를 고르도록 선정
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
        dfs(0, 0);

        System.out.println(sb.toString());
    }
}
