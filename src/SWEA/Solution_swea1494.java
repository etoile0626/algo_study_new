package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    지렁이들이 움직인 벡터 합의 크기가 작기를 바란다.
    지렁이들은 2차원 평면 안에서 이동하는데, 점 A 위에 있는 지렁이가 점 B 위에 있는 지렁이에게 갔다면 그 벡터는 점 A에서 점 B를 가리키는 벡터가 된다.
    벡터 V=(x, y)의 크기는 아래와 같이 정의하자.
    │V│=│(x, y)│= x * x + y * y
    모든 지렁이들을 매칭시키고 소개팅을 주선하되, 각 지렁이들이 움직인 "벡터를 합하여" 그 크기가 최소가 되도록
 */

public class Solution_swea1494 {                            //사랑의 카운슬러
    //다시 풀기
    static int n;
    static long min;
    static int[][] arr;
    static boolean[] visit;

    //백트래킹
    private static void dfs(int idx, int cnt){
        if(cnt == n/2){
            long xSum = 0;
            long ySum = 0;

            for(int i =0; i < n; i++){
                if(visit[i]){                                   //각 벡터의 시작점
                    xSum += arr[i][0];
                    ySum += arr[i][1];
                } else{                                         //각 벡터의 도착점
                    xSum -= arr[i][0];
                    ySum -= arr[i][1];
                }
            }

            min = Math.min(min, xSum * xSum + ySum * ySum);
        }

        for(int i = idx; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i+1, cnt+1);
                visit[i] = false;
            }
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
            min = Long.MAX_VALUE;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
