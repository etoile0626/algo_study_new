package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    프린트 요청이 여러개 쌓이면 큐에 쌓여서 FIFO 형태로 인쇄가 됨.
    새로 만든 프린터 큐는
    1. 문서당 중요도를 확인
    2. 현재 문서보다 중요도가 높은 문서가 하나라도 있으면, 현재 문서를 큐의 가장 뒤에 재배치. 그렇지 않으면 출력
    이때, 어떤 한 문서가 몇 번째로 출력되는지 알아보기
    *1 <= 문서 개수 n <= 100, 몇번째 인덱스의 문서가 궁금한지 나타내는 0 <= m < n
    *중요도는 1이상 9이하, 중요도가 같은 문서 존재 가능.
 */

public class Main_BJ1966 {                              //프린터 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int T =0; T < t; T++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());     //내림차순으로 정렬
            int order = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int num = Integer.parseInt(st.nextToken());
                q.offer(new int[] {num, i});
                pq.offer(num);
            }

            while(!q.isEmpty()){
                int []num = q.poll();

                if(num[0] >= pq.peek()){
                    pq.poll();
                    order++;

                    if(num[1] == m){
                        break;
                    }
                } else {
                    q.offer(num);
                }
            }

            System.out.println(order);
        }
    }
}
