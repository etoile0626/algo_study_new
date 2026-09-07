package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
    2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]
    위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.
    *공백 문자 후 수정된 암호문의 처음 10개 항을 출력한다.
 */

public class Solution_swea1229 {                    //[S/W 문제해결 기본] 8일차 - 암호문2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            int order = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < order; i++){
                String str = st.nextToken();
                if(str.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j = 0; j < y; j++) {
                        int num = Integer.parseInt(st.nextToken());

                        list.add(x + j, num);
                    }
                } else {            //str == "D"
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j = 0; j < y; j++) {
                        list.remove(x);
                    }
                }
            }

            sb.append("#").append(t);
            for(int i = 0; i < 10; i++) {
                sb.append(" ").append(list.get(i));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
