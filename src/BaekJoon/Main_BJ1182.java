package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서
 */

public class Main_BJ1182 {                      //부분수열의 합

    static int n, s, cnt;
    static int[] arr;

    static void dfs(int idx, int value){
        if(idx == n){
            if(value == s){
                cnt++;
            }
            return;
        }

        dfs(idx + 1, value + arr[idx]);                     //idx번째 원소를 고르거나
        dfs(idx + 1, value);                                        //안고르거나
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;

        dfs(0, 0);
        if(s == 0){
            cnt--;                              //공집합은 제외
        }

        System.out.println(cnt);
    }
}
