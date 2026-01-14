package Programmers;

/*
    자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 경우의 수가 얼마인지 구하고자 함
    *원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아짐
 */

import java.util.HashSet;
import java.util.Set;

public class Solution_Pro131701 {                       //연속 부분 수열 합의 개수
    class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();
            int n = elements.length;

            for(int i = 0; i < n; i++){         //i번째 인덱스에서 시작
                int sum = 0;

                for(int len = 0; len < n; len++){   //길이가 len+1(i번 인덱스부터)인 연속 부분 수열의 합
                    sum += elements[(i + len) % n];      //i번째 인덱스에서 시작하는 부분수열이 len+1크기인 sum구하기
                    set.add(sum);
                }
            }

            int answer = set.size();
            return answer;
        }
    }
}
