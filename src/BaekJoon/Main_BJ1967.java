package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    트리에서 어떤 두 노드를 선택해 양쪽으로 길게 땡기면, 가장 길게 늘어나는 경우가 존재.
    이 가장 길에 늘어나는 두 노드사이의 경로의 길이를 트리의 지름이라고 할 때,
    주어진 트리의 지름을 구하는 프로그램 작성하기
 */

public class Main_BJ1967 {                      //트리의 지름

    static int n, max, last;                        //노드 개수, 최댓값, 최댓값 시 노드
    static Queue<int[]>[] tree;
    static boolean[] visited;

    static void dfs(int start, int dist){
        visited[start] = true;

        if(dist > max){
            max = dist;
            last = start;
        }

        for(int[] tmp : tree[start]){
            int node = tmp[0];
            int w = tmp[1];

            if(!visited[node]){                 //방문하지 않은 노드면
                dfs(node, dist + w);        //거리 갱신해서 dfs 시작
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        max = 0;
        visited = new boolean[n+1];

        tree = new ArrayDeque[n+1];
        for(int i = 0; i <= n; i++){
            tree[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());                       //가중치

            tree[n1].offer(new int[] {n2, v});
            tree[n2].offer(new int[] {n1, v});
        }

        dfs(1, 0);                                                  //1번 노드에서 거리 0으로 시작
        Arrays.fill(visited, false);                                     //visited 초기화
        dfs(last, 0);                                                   //가장 멀리 있는 노드에서 다시 dfs

        System.out.println(max);
    }
}
