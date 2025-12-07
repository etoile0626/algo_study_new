package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    n명의 유저와 m개의 관계가 주어질 때, 유저들 중 가장 작은 케빈 베이컨 수를 지닌 사람 구하기
 */

public class Main_BJ1389 {                                  //케빈 베이컨의 6단계 법칙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer>[] graph = new ArrayDeque[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayDeque<>();
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int answer[] = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            Queue<Integer> q = new ArrayDeque<>();
            int[] dist = new int[n + 1];

            q.add(i);

            Arrays.fill(dist, -1);
            dist[i] = 0;
            while (!q.isEmpty()) {
                int current = q.poll();
                for (int next : graph[current]) {
                    if (dist[next] == -1) {
                        dist[next] = dist[current] + 1;
                        q.add(next);
                    }
                }
            }

            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                sum += dist[j];
            }
            answer[i] = sum;
        }

        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 1; i < n + 1; i++) {
            if (answer[i] < min) {
                min = answer[i];
                num = i;
            }
        }
        System.out.println(num);
    }
}
