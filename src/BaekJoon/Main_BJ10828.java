package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    정수를 저장하는 스택 구현후 명령 처리하기
 */

public class Main_BJ10828 {                     //스택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("push")){
                int x = Integer.parseInt(st.nextToken());

                s.push(x);
            }
            else if(order.equals("pop")){
                if(s.isEmpty()){
                    System.out.println(-1);

                    continue;
                }

                System.out.println(s.pop());
            }
            else if(order.equals("size")){
                System.out.println(s.size());
            }
            else if (order.equals("empty")){
                if(s.isEmpty()){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
            }
            else if(order.equals("top")){
                if(s.isEmpty()){
                    System.out.println(-1);

                    continue;
                }

                System.out.println(s.peek());
            }
        }
    }
}
