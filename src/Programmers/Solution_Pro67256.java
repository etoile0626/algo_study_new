package Programmers;

/*
    휴대전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 함.
    왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작.
    1. 손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1
    2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 / 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 사용
    3. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 손의 현재 키패드의 위치에서 더 가까운 손을 사용.
    *거리가 같다면, 오른손잡이는 오른손, 왼손잡이는 왼손을 사용.
    각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성.
 */

public class Solution_Pro67256 {                        //키패드 누르기
    class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();

            int left = 10;                      //*
            int right = 12;                     //#

            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] == 0){
                    numbers[i] = 11;
                }

                if(numbers[i] % 3 == 1){                                //1, 4, 7
                    left = numbers[i];
                    sb.append("L");
                } else if(numbers[i] % 3 == 0){                         //3, 6, 9
                    right = numbers[i];
                    sb.append("R");
                } else{                                                 //2, 5, 8, 0
                    //목표 번호까지 거리 계산
                    int dist_l = (Math.abs(left - numbers[i]) / 3) + (Math.abs(left - numbers[i]) % 3);
                    int dist_r = (Math.abs(right - numbers[i]) / 3) + (Math.abs(right - numbers[i]) % 3);

                    if(dist_l < dist_r){
                        left = numbers[i];
                        sb.append("L");
                    } else if(dist_l > dist_r){
                        right = numbers[i];
                        sb.append("R");
                    } else{
                        if(hand.equals("left")){
                            left = numbers[i];
                            sb.append("L");
                        } else{
                            right = numbers[i];
                            sb.append("R");
                        }
                    }
                }
            }

            return sb.toString();
        }
    }
}
