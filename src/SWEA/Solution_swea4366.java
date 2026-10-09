package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

/*
    송금할 금액을 까먹고 말았다.
    하지만 다행스럽게도 정식이는 평소 금액을 2진수와 3진수의 두 가지 형태로 기억하고 다니며,
    기억이 명확하지 않은 지금조차 2진수와 3진수 각각의 수에서 단 한 자리만을 잘못 기억하고 있다는 것만은 알고 있다.
    예를 들어 현재 기억이 2진수 1010과 3진수 212을 말해주고 있다면 이는 14의 2진수인 1110와 14의 3진수인 112를 잘못 기억한 것이라고 추측할 수 있다.
    정식이가 송금액을 추측하는 프로그램을 만들어주자.
    *단, 2진수와 3진수의 값은 무조건 1자리씩 틀리다.  추측할 수 없는 경우는 주어지지 않는다.
 */

public class Solution_swea4366 {                        //정식이의 은행업무
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringBuilder str2 = new StringBuilder(br.readLine());                            //2진법
            StringBuilder str3 = new StringBuilder(br.readLine());                            //3진법
            long answer = 0;

            Set<Long> set = new HashSet<>();

            //2진법
            for(int i = 0; i < str2.length(); i++){
                char origin = str2.charAt(i);
                char fix;
                if(origin == '0'){
                    fix = '1';
                } else {
                    fix = '0';
                }

                str2.setCharAt(i, fix);
                set.add(Long.parseLong(str2.toString(), 2));
                str2.setCharAt(i, origin);
            }

            //3진법
            for(int i = 0; i < str3.length(); i++){
                char origin = str3.charAt(i);

                for(char c = '0'; c <= '2'; c++){
                    if(c == origin) {
                        continue;
                    }

                    str3.setCharAt(i, c);
                    long value = Long.parseLong(str3.toString(), 3);

                    if(set.contains(value)) {
                        answer = value;
                    }
                }

                str3.setCharAt(i, origin);
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
