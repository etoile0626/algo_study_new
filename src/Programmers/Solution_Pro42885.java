package Programmers;

/*
    구명보트를 통해 무인도를 탈출하려고 하나, 구명보트에는 최대 2인만 탑승 가능, 무게 제한도 존재.
    구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 할 때, 필요한 구명보트의 최솟값 구하기.
 */

import java.util.Arrays;

public class Solution_Pro42885 {                            //구명보트
    class Solution {
        public int solution(int[] people, int limit) {
            int n = people.length;
            int answer = 0;

            //오름차순 정렬
            Arrays.sort(people);

            //투 포인터 사용
            int left = 0;
            int right = n-1;

            while(left <= right){
                //큰 사람 포함해서 2명 못데리고 가면 가장 큰 사람 한 명만
                if(people[left] + people[right] > limit){
                    right--;
                }
                //데리고 갈 수 있으면 둘 다 데리고 가기
                else{
                    left++;
                    right--;
                }

                answer++;
            }

            return answer;
        }
    }
}
