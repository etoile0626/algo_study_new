package Programmers;

/*
    버튼 종류가  절댓값이 10c 인 애들밖에 없음
    https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */

public class Solution_Pro148653 {               //마법의 엘리베이터

    class Solution {
        public int solution(int storey) {
            int answer = 0;

            while(storey > 0) {
                int m = storey % 10;                    //현재 자리수
                int next = (storey / 10) % 10;          //다음 자리수 (carry 판단용)
                storey = storey / 10;

                if(m > 5){
                    answer += (10 - m);
                    storey += 1;               //다음 자리수 값에 1 더해주기(=carry)
                } else if(m == 5){              //이번 자리수가 5이면 다음 자리수에 따라 누르는거 판단
                    if(next >= 5){              //5보다 크면 carry하는게 더 낫다고 판단
                        answer += 5;
                        storey += 1;           //다음 자리수 값에 1 더해주기(=carry)
                    } else{                     //그렇지 않으면 그냥 -1 5번 누르기
                        answer += 5;
                    }
                } else{
                    answer += m;                //-1 m번 누르기
                }
            }

            return answer;
        }
    }
}
