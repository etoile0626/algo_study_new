package Programmers;

/*
    민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 됨.
    당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알고 싶음.
    *알아볼 수 없는 번호를 0으로 표기
    *순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정
    당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하기
 */

public class Solution_Pro77484 {                                    //로또의 최고 순위와 최저 순위
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int[] rank = {6, 6, 5, 4, 3, 2, 1};         //맞는 개수에 따른 등수

            for(int i = 0; i < lottos.length; i++){
                if(lottos[i] == 0){             //모르는 번호는 최고 등수로 간주(맞는 번호라 쳐!)
                    answer[0]++;
                    continue;
                }

                for(int j = 0; j < win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){   //맞는 번호는 최고, 최저의 경우 모두 맞는 개수 증가
                        answer[0]++;
                        answer[1]++;
                    }
                }
            }

            //개수에 맞게 등수 변환
            answer[0] = rank[answer[0]];
            answer[1] = rank[answer[1]];

            return answer;
        }
    }
}
