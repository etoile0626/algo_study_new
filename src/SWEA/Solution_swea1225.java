package SWEA;

/*
    8개의 숫자를 입력 받는다.
    첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다.
        다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.
        이와 같은 작업을 한 사이클이라 한다. (5 감소하고 나면 다시 1감소)
    숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호.
    *각 수는 정수 범위를 넘지 않음(int)
    *마지막 암호 배열은 모두 한 자리 수로 구성
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_swea1225 {                                    //[S/W 문제해결 기본] 7일차 - 암호생성기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8; i++){
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int idx = 1;
            while(!q.isEmpty()){
                int n = q.poll();
                n = n - idx;
                if(n < 0){
                    n = 0;
                }

                q.offer(n);

                idx++;
                if(idx == 6){
                    idx = 1;
                }

                if(n == 0){
                    break;
                }
            }

            sb.append("#").append(T);
            for(int i = 0; i < 8; i++){
                sb.append(" ").append(q.poll());
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
