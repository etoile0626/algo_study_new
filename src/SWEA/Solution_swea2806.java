package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    8*8 체스보드에 8개의 퀸을 서로 공격하지 못하게 놓는 문제는 잘 알려져 있는 문제다.
    N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수를 구하기.
 */

public class Solution_swea2806 {                                //N-Queen
    //다시 풀기. 대각선 고려하는 백트래킹까진 생각나는데 그 구현과정을 버벅이네
    static int n, cnt;
    static int[] arr;

    private static void dfs(int idx){
        if(idx == n){
            cnt++;
            return;
        }

        boolean flag = false;

        for(int i = 0; i < n; i++){
            flag = true;

            for(int j = 0; j < idx; j++){
                //이미 놓인 퀸의 직선 / 대각선1 / 대각선2에 위치한다면 탈락
                if(arr[j] == i || i == arr[j] + (idx - j) || i == arr[j] - (idx - j)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                arr[idx] = i;
                dfs(idx+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new int[n];                   //arr[0] = 1/ (0,1)에 퀸을 둔다는 의미

            dfs(0);

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
