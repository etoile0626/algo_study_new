package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    초기에 최대 힙이 비어있을 때에 다음의 2가지 연산을 수행하는 프로그램을 작성하자.
    연산 1. 자연수 x를 삽입
    연산 2. 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제
    *연산 1을 수행해야 한다면 2개의 자연수 '1 x'가 주어지며, x(1≤x≤109)를 최대 힙에 추가하는 연산임을 의미한다.
    *연산 2를 수행해야 한다면 1개의 자연수 '2'가 주어지며, 현재 최대 힙의 루트 노드의 키값을 출력하고 해당 노드를 삭제하는 연산임을 의미.
    연산 2의 결과들을 공백 하나를 사이에 두고 순서대로 출력한다.
    만약, 연산 2를 수행해야 하는데 힙에 원소가 없어서 출력해야 할 최대 키값이 존재하지 않는다면 -1을 출력
 */

public class Solution_swea2930 {                    //힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = Integer.parseInt(br.readLine());

            sb.append("#").append(t);

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());

                if(order == 1){
                    int num = Integer.parseInt(st.nextToken());
                    pq.offer(num);
                }
                else{
                    int num = -1;

                    if(!pq.isEmpty()) {
                        num = pq.poll();
                    }

                    sb.append(" ").append(num);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
