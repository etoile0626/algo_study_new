package Programmers;

/*
    n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
    사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return하기.
    ex) 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.
    [1, 2, 3] / [1, 3, 2] / [2, 1, 3] / [2, 3, 1] / [3, 1, 2] / [3, 2, 1]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_Pro12936 {                        //줄 서는 방법
    //다시 풀어보기
    class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];
            long total = 1;
            List<Integer> list = new ArrayList<>();

            for(int i = 1; i <= n; i++){
                list.add(i);
                total *= i;
            }

            k--;                                        //인덱스는 0번부터이므로 가공처리

            for(int idx = 0; idx < n; idx++){
                total = total / (n - idx);                          //idx만큼 찾고자하는 수가 줄어들어서 n-idx
                answer[idx] = list.remove((int)(k / total));        //k는 long이므로 형변환
                k = k % total;
            }

            return answer;
        }
    }
}
