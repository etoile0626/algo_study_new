package Programmers;

public class Solution_Pro12932 {                                //자연수 뒤집어 배열로 만들기
    class Solution {
        public int[] solution(long n) {
            String[] arr = Long.toString(n).split("");
            int len = arr.length;
            int[] answer = new int[len];

            for(int i = 0; i < len; i++){
                answer[i] = Integer.parseInt(arr[len - i - 1]);
            }

            return answer;
        }
    }
}
