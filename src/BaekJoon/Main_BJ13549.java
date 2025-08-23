package BaekJoon;

import java.util.*;

/*
    수빈이가 동생과 숨바꼭질 중
    수빈이의 위치 n, 동생의 위치 k에 존재.
    *(0 <= n <= 100000, 0 <= k <= 100000, n과 k는 정수)
    수빈이는 걷거나, 순간이동이 가능.
    걷는 경우 1초 후 x+1 혹은 x-1로 이동.
    순간이동의 경우 0초 후 2 * x의 위치로 이동 (시간 소모 x)
    수빈이가 동생을 찾는 가장 빠른 시간이 몇 초 후인지 구하기
 */

public class Main_BJ13549 {                         //숨바꼭질 3

    static int n, k;
    static int[] time;
    static boolean[] visited;

    private static int bfs() {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);           //시간 기준 오름차순 정렬 -> 시간이 적게 걸리는 애들 먼저 큐에서 뽑도록

        pq.offer(new int[] {n, 0});

        while(!pq.isEmpty()){
            int[] num = pq.poll();

            visited[num[0]] = true;

            if(num[0] == k){
                return num[1];
            }

            //순간이동 (시간초 0)
            int num1 = num[0] * 2;
            if(num1 <= 100000 && !visited[num1]){
                pq.offer(new int[] {num1, num[1]});
            }

            //앞으로 한 칸(1초)
            int num2 = num[0] + 1;
            if(num2 <= 100000 && !visited[num2]){
                pq.offer(new int[] {num2, num[1] + 1});
            }

            //뒤로 한 칸(1초)
            int num3 = num[0] -1;
            if(num3 >= 0 && !visited[num3]){
                pq.offer(new int[] {num3, num[1] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[100001];

        int times = bfs();

        System.out.println(times);
    }
}
