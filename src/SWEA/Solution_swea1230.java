package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    0 ~ 999999 사이의 수로 표현되는 암호문이 있고, 이 암호문을 N개 모아 놓은 암호문 뭉치가 있다.
    다음과 같이 3개의 명령어로 제어한다.
    1. I(삽입) x, y, s : 앞에서부터 x번째 암호문 바로 다음에 y개의 암호문을 삽입한다. s는 덧붙일 암호문들이다.[ ex) I 3 2 123152 487651 ]
    2. D(삭제) x, y : 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.[ ex) D 4 4 ]
    3. A(추가) y, s : 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다. s는 덧붙일 암호문들이다. [ ex) A 2 421257 796813 ]
    암호문 뭉치를 수정하고, 수정된 결과의 처음 10개 암호문을 출력하기.
 */

public class Solution_swea1230 {                //[S/W 문제해결 기본] 8일차 - 암호문3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                String order = st.nextToken();

                if(order.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j = 0; j < y; j++) {
                        int s = Integer.parseInt(st.nextToken());

                        list.add(x + j, s);
                    }
                } else if(order.equals("D")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j = 0; j < y; j++){
                        list.remove(x);
                    }

                } else if(order.equals("A")){
                    int y = Integer.parseInt(st.nextToken());

                    for(int j = 0; j < y; j++){
                        int s = Integer.parseInt(st.nextToken());
                        list.add(s);
                    }
                }
            }

            sb.append("#").append(t);
            for(int i = 0; i < 10; i++){
                sb.append(" ").append(list.get(i));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
