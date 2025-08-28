package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개의 자연수와 자연수 m이 주어졌을 때, 아래 조건을 만족하는 길이가 m인 수열을 모두 구하는 프로그램을 작성하시오.
    *n개의 자연수는 모두 다르며, n개의 자연수 중 m개를 고른 수열, 같은 수를 여러번 골라도 된다.
    *1 <= m <= n <= 7 / 입력으로 주는 수는 10000보다 작거나 같은 자연수
    *한줄에 하나씩 수열 출력, 중복되는 수열은 출력 x, 사전순으로 증가하는 순으로
 */

public class Main_BJ15656 {                                     //N과 M (7)
    
    static int n, m;
    static int[] arr, result;
    static StringBuilder sb;

    private static void dfs(int cnt) {
        if(cnt == m){
            for(int i : result){
                sb.append(i).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            result[cnt] = arr[i];
            dfs(cnt+1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());
    }
}
