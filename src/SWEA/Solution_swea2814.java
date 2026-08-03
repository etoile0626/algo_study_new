package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    N개의 정점과 M개의 간선으로 구성된 가중치가 없는 무방향 그래프에서의 최장 경로의 길이를 계산하자.
    정점의 번호는 1번부터 N번까지 순서대로 부여되어 있다.
    경로에는 같은 정점의 번호가 2번 이상 등장할 수 없으며, 경로 상의 인접한 점들 사이에는 반드시 두 정점을 연결하는 간선이 존재해야 한다.
    경로의 길이는 경로 상에 등장하는 정점의 개수를 나타낸다.
 */

public class Solution_swea2814 {                        //최장 경로
    static int n, dist, max;
    static boolean[] visit;
    static List<Integer>[] graph;

    private static void dfs(int node){
        visit[node] = true;

        max = Math.max(max, dist);

        for(int num : graph[node]){
            if(!visit[num]){
                dist++;
                dfs(num);
                dist--;                 //백트래킹
            }
        }

        visit[node] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            max = 0;
            visit = new boolean[n+1];
            graph = new ArrayList[n+1];

            for(int i = 1; i <= n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            for(int i = 1; i <= n; i++){
                dist = 1;
                dfs(i);
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
