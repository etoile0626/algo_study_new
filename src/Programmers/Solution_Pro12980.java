package Programmers;

/*
    K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동 가능.
    순간이동을 하면 건전지 사용량이 줄지 않지만, 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용.
    거리가 N 만큼 떨어져 있는 장소로 가려고 합니다. 단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하기.
 */

public class Solution_Pro12980 {                        //점프와 순간 이동
    public class Solution {
        public int solution(int n) {
            int ans = 0;                            //배터리 사용량

            //top-bottom 방식으로 접근
            while(n != 0){
                if(n % 2 == 0){                         //짝수면 텔포전과 배터리 값이 같음
                    n = n/2;
                } else{                                 //홀수면 한칸은 점프해야 함
                    n -= 1;                             //한 칸 점프
                    ans++;
                }
            }

            return ans;
        }
    }
}
