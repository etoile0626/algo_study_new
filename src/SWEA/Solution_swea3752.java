package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    학생들의 시험을 위해 N개의 문제를 만들었다.
    각 문제의 배점은 문제마다 다를 수 있고, 틀리면 0점 맞으면 배점만큼의 점수를 받게 된다.
    학생들이 받을 수 있는 점수로 가능한 '경우의 수'는 몇 가지가 있을까?
 */

public class Solution_swea3752 {                        //가능한 시험 점수
    static int n, count;
    static int[] arr;
    static boolean[][] visit;


    private static void dfs(int cnt, int score){                  //백트레킹 함수
        if (visit[cnt][score]) {
            return;
        }

        visit[cnt][score] = true;

        if (cnt == n) {
            count++;
            return;
        }

        //cnt번 문제를 틀린 경우
        dfs(cnt+1, score);

        //cnt번 문제를 맞춘 경우
        dfs(cnt+1, score + arr[cnt]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            visit = new boolean[n+1][10001];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
