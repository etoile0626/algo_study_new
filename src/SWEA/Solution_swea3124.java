package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
    *최소 스패닝 트리 = 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
 */

public class Solution_swea3124 {                    //최소 스패닝 트리
    //다시 풀기

    private static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);                       //x, y의 부모 찾기

        if(x != y) {
            if (x <= y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    private static int find(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }

        parent[node] = find(parent, parent[node]);

        return parent[node];
    }

    private static long mst(List<int[]> graph, int[] parent){                          //크루스칼 알고리즘
        long w = 0;
        for(int i = 0; i < graph.size(); i++){
            int[] tmp = graph.get(i);

            if(find(parent, tmp[0]) != find(parent, tmp[1])){                              //부모가 다른 경우 유니온 연산
                w += tmp[2];
                union(parent, tmp[0], tmp[1]);
            }
        }

        return w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<int[]> graph = new ArrayList<>();                              //{n1, n2, e}, i번째로 가중치가 낮은 간선

            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.add(new int[] {a, b, c});
            }

            //>>>>크루스칼의 핵심<<<<
            graph.sort(Comparator.comparingInt(edge -> edge[2]));               //가중치를 기준으로 간선 정렬

            // 부모노드 초기화
            int[] parent = new int[v + 1];                              //i번 노드의 부모 노드는 parent[i]
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            long cnt = mst(graph, parent);                              //크루스칼 알고리즘 수행
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
