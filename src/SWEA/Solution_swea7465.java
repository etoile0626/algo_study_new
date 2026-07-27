package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.
    두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다.
    두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,
    이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.
    창용 마을에 몇 개의 무리가 존재하는지 계산하기.
 */

public class Solution_swea7465 {                            //창용 마을 무리의 개수
    static List<Integer>[] graph;
    static boolean[] visit;
    private static void dfs(int node){
        for(int n : graph[node]){
            if(!visit[n]){
                visit[n] = true;
                dfs(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n+1];
            visit = new boolean[n+1];
            int cnt = 0;

            for(int i = 1 ; i <= n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            for(int i = 1 ; i <= n; i++){
                if(!visit[i]){
                    visit[i] = true;
                    dfs(i);
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
