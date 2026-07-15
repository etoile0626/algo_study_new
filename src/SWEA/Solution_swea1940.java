package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    매 초마다 아래와 같은 command 가 정수로 주어진다.
    0 : 현재 속도 유지.
    1 : 가속
    2 : 감속

    위 command 중, 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.
    가속도의 단위는, m/s2 이며, 모두 양의 정수로 주어진다.
    입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 '거리'를 계산하는 프로그램을 작성하라.
    RC 카의 초기 속도는 0 m/s 이다.
 */

public class Solution_swea1940 {                        //가랏! RC카!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int speed = 0;                                          //현재 차의 속도
            int dist = 0;                                           //이동거리

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int acc = 0;                                        //이번에 증감할 속도의 양

                if(command != 0){
                    acc = Integer.parseInt(st.nextToken());

                    if(command == 2){
                        acc *= -1;
                    }
                }

                speed += acc;
                if(speed < 0){                                      //음수인 속력은 없으므로 0으로 초기화
                    speed = 0;
                }

                dist += speed;
            }

            sb.append("#").append(t).append(" ").append(dist).append("\n");
        }

        System.out.println(sb.toString());
    }
}
