package Programmers;

/*
    숫자 중 3개의 수를 더했을때 소수가 되는 경우의 수를 구하고자 함.
    nums 배열에 있는 숫자 중 서로 다른 3개를 더했을 때 소수가 되는 경우의 수를 구하기.
 */

public class Solution_Pro12977 {                            //소수 만들기
    class Solution {
        static int answer;          //정답은 전역변수 처리

        //소수 검증 함수
        public boolean isPrime(int n){
            for(int i = 2; i*i <= n; i++){          //제곱근이 나누어지면 소수가 아님
                if(n % i == 0){
                    return false;
                }
            }

            return true;
        }


        //백트래킹 함수
        public void dfs(int[] nums, int sum, int start, int cnt){
            if(cnt == 3){
                if(isPrime(sum)){
                    answer++;
                }

                return;
            }

            for(int i = start; i < nums.length; i++){
                dfs(nums, sum + nums[i], i+1, cnt+1);
            }
        }

        public int solution(int[] nums) {
            answer = 0;

            dfs(nums, 0, 0, 0);

            return answer;
        }
    }
}
