package Programmers;

public class Solution_Pro12935 {                        //제일 작은 수 제거하기
    class Solution {
        public int[] solution(int[] arr) {
            int n = arr.length;
            int[] answer = new int[n-1];

            if(n == 1){
                answer = new int[] {-1};
            } else{
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < n; i++){
                    if(min > arr[i]){
                        min = arr[i];
                    }
                }

                int idx = 0;
                for(int i = 0; i < n; i++){
                    if(min == arr[i]){
                        continue;
                    }

                    answer[idx] = arr[i];
                    idx++;
                }
            }

            return answer;
        }
    }
}
