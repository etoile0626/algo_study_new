package Programmers;

/*
    A 나라와 B 나라가 싸우고 있는 이 세계는 2 차원 공간
    A 나라가 발사한 폭격 미사일은 x 축에 평행한 직선 형태의 모양이며 개구간을 나타내는 정수 쌍 (s, e) 형태
    B 나라는 해당 x 좌표에 걸쳐있는 모든 폭격 미사일을 관통하여 한 번에 요격
    개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격X
    요격 미사일은 실수인 x 좌표에서도 발사가능
    모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 return 하도록 solution 함수를 완성
 */

import java.util.Arrays;

public class Solution_Pro181188 {               //요격 시스템
    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            int missile = 0;    //현재 요격할 미사일 위치, 낮은 x좌표에서부터 시작

            Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

            for(int[] arr : targets){
                if(missile <= arr[0]){
                    answer++;
                    missile = arr[1];
                }
            }

            return answer;
        }
    }
}
