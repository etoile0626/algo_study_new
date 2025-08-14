package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    무방향 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램을 작성하시오.
    *1 <= n <= 1000 / 0 <= m <= n(n-1)/2
    *1 <= u / v <= n / u != v
    연결 요소 = 그래프 내에서 정점들이 서로 연결되어 만들어지는 최대 연결 부분 그래프
 */

public class Main_BJ11724 {                             // 연결 요소의 개수

    static List<Integer>[] graph;
    static boolean[] visited;
    static int n, m, cnt;

    private static void dfs(int i) {
        if(visited[i]){
            return;
        }

        visited[i] = true;

        for(int next : graph[i]){
            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
