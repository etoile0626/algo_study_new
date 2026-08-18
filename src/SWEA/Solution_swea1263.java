package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    사용자 i의 CC(i)는 다음과 같이 계산된다.
    CC(i) = ∑ j dist(i,j) / 단, dist(i,j)는 노드i로부터 노드 j까지의 최단 거리
    주어진 사람 그래프에서 사람들의 CC 값들 중에서 최솟값을 구하기
    ->다익스트라?
 */

public class Solution_swea1263 {                    //[S/W 문제해결 응용] 8일차 - 사람 네트워크2
    static int n;
    static int[][] graph;
    static int[] dist;

    private static void bfs(int start){
        boolean[] visit = new boolean[n+1];
        visit[start] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {start, 0});

        int sum = 0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int node = tmp[0];
            int cnt = tmp[1];

            for(int i = 1; i <= n; i++){
                if(graph[node][i] == 1 && !visit[i]){                   //다음 노드 발견시
                    visit[i] = true;
                    q.offer(new int[] {i, cnt + 1});                    //bfs 진행
                    sum += cnt + 1;                                     //이때의 거리값 합하기
                }
            }

            dist[start] = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            graph = new int[n+1][n+1];                  //인접행렬 그래프
            dist = new int[n+1];                          //각 노드의 최소거리 합 구하는 배열
            int min = Integer.MAX_VALUE;

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1; i <= n; i++){
                bfs(i);
            }

            for(int i = 1; i <= n; i++){
                min = Math.min(min, dist[i]);
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
