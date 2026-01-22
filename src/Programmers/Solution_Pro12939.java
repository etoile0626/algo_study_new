package Programmers;

/*
    공백으로 구분된 숫자들이 문자열에 저장.
    숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수 만들기.
 */

import java.util.Arrays;

public class Solution_Pro12939 {                                //최댓값과 최솟값
    class Solution {
        public String solution(String s) {
            String[] str = s.split(" ");

            int n = str.length;
            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(str[i]);
            }

            Arrays.sort(arr);

            String answer =  (String)(arr[0] + " " + arr[n-1]);
            return answer;
        }
    }
}
