package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    공은 열린 괄호와 닫힌 괄호가 붙어 있는 ‘()’로 표현되며, 서로 다른 두 공이 겹치지 않는다.
    여기에 잡초가 자라서 몇 개의 칸이 가려지게 되었다. 잡초는 ‘|’로 표현된다.
    위와 같은 과정을 통해 얻어진 문자열이 주어진다. 이때, 초원에 놓았을 수 있는 공의 개수의 최솟값을 구하기.
 */

public class Solution_swea14555 {                           //공과 잡초
    //다시 풀기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int min = 0;
            String str = br.readLine();

            for (int i = 0; i < str.length() - 1; i++) {
                char a = str.charAt(i);
                char b = str.charAt(i + 1);

                //1.() 2.(| 3. |)
                if ((a == '(' && b == ')') || (a == '(' && b == '|') || (a == '|' && b == ')')) {
                    min++;
                    i++; // 두 글자를 한 공으로 사용했으니 건너뜀
                }
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
