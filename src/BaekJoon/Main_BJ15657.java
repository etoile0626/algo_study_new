package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개의 자연수와 m이 주어질때, 아래 조건을 만족하는 길이가 m인 수열을 모두 구하기
    1. n개중 m개를 고른 수열
    2. 같은 수를 여러번 골라도 됨.
    3. 고른 수열은 비내림차순(=오름차순?)이여야 한다.
    * 중복하는 수열을 여러번 출력 x
 */

public class Main_BJ15657 {                     //N과 M (8)

    static int n, m;
    static int[] arr, tmp;
    static StringBuilder sb;

    static void bfs(int cnt, int idx){
        if(cnt == m){
            for(int i = 0; i < m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        int prev = 0;
        for(int i = idx; i < n; i++){
            if(arr[i] == prev) {                    //입력 중복 제거용
                continue;
            }
            prev = arr[i];

            tmp[cnt] = arr[i];
            bfs(cnt+1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        tmp = new int[m];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        bfs(0, 0);

        System.out.println(sb.toString());
    }
}
