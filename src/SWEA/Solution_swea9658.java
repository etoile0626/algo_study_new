package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    주어진 정수의 앞 두 자리를 유효숫자로 하여 표기하는 프로그램을 작성하세요.
    예를 들어 정수 588235는 5.88235*10^5 인데, 앞의 소수 부분을 소수점 두 번째 자리에서 반올림하여 5.9*10^5로 나타내는 것입니다.
    하나의 예외로, 9999 같은 경우 9.999*10^3에서 9.999의 소수점 두 번째 자리를 반올림하여 1.0*10^4으로 나타내야 합니다.
 */

public class Solution_swea9658 {                //유효숫자 표기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int exponent = str.length() - 1;                    //지수(10의 몇승?)

            int first = str.charAt(0) - '0';                    //일의 자리
            int second = str.charAt(1) - '0';                   //소수첫째자리

            //소수 두째자리에서 반올림처리
            if (str.charAt(2) >= '5') {
                second++;

                if (second == 10) {
                    first++;
                    second = 0;

                    if (first == 10) {                          //10의 자리로 넘어가면 지수 증가시키기
                        first = 1;
                        exponent++;
                    }
                }
            }

            sb.append('#').append(t).append(' ')
                    .append(first).append('.').append(second).append("*10^").append(exponent)
                    .append('\n');
        }

        System.out.println(sb.toString());
    }
}
