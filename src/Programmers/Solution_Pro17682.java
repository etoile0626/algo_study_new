package Programmers;

/*
    다트 게임의 점수 계산 로직은 아래와 같다.
    1. 총 3번의 기회로 구성
    2. 점수는 0점에서 10점까지
    3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
    4. 옵션으로 스타상(*) 당첨 시 '해당 점수와 바로 전에 얻은 점수'를 각 2배로 만든다. 아차상(#) 당첨 시 '해당 점수'는 마이너스된다.
    4-1. 첫번째에 스타상이 나오는 경우 첫 번째 스타상(*)의 점수만 2배
    5. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩 가능, 이 경우 중첩된 스타상(*) 점수는 4배.
    6. 스타상(*)의 효과는 아차상(#)의 효과와 중첩 가능, 이 경우 중첩된 아차상(#)의 점수는 -2배.
    7. Single(S), Double(D), Triple(T)은 점수마다 하나씩.
    8. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
    0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하기.
    *점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
    ex) 1S2D*3T	-> 37
 */

import java.util.StringTokenizer;

public class Solution_Pro17682 {                                        //[1차] 다트 게임
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int[] num = new int[3];
            int idx = 0;

            for(int i = 0; i < dartResult.length(); i++){
                char c = dartResult.charAt(i);

                //0이면 넘기기(10이면 앞에 1일대 처리 될거고 0이면 계산 안해도 됨)
                if(c == '0'){
                    continue;
                }

                if(c >= '1' && c <= '9'){
                    if(dartResult.charAt(i+1) == '0'){
                        num[idx] = 10;
                    } else{
                        num[idx] = c - '0';
                    }

                }

                if(c == 'S'){
                    num[idx] = (int)Math.pow(num[idx], 1);
                    idx++;
                }else if(c == 'D'){
                    num[idx] = (int)Math.pow(num[idx], 2);
                    idx++;
                }else if(c == 'T'){
                    num[idx] = (int)Math.pow(num[idx], 3);
                    idx++;
                }

                if(c == '*'){
                    if(idx-1 != 0){
                        num[idx-2] *= 2;
                    }
                    num[idx-1] *= 2;
                } else if(c == '#'){
                    num[idx-1] *= -1;
                }
            }

            answer = num[0] + num[1] + num[2];
            return answer;
        }
    }
}
