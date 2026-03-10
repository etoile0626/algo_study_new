package Programmers;

public class Solution_Pro12901 {                            //2016년
    class Solution {
        public String solution(int a, int b) {
            String answer = "";
            int days = 0;


            for(int i = 1; i < a; i++){
                if((i <= 7 && i % 2 == 1) || (i > 7 && i % 2 == 0)){
                    days += 31;
                } else if(i == 2){
                    days += 29;
                } else if((i <= 7 && i % 2 == 0) || (i > 7 && i % 2 == 1)){
                    days += 30;
                }
            }

            days += b;

            days = days % 7;

            if(days == 1){
                answer = "FRI";
            } else if(days == 2){
                answer = "SAT";
            } else if(days == 3){
                answer = "SUN";
            } else if(days == 4){
                answer = "MON";
            } else if(days == 5){
                answer = "TUE";
            } else if(days == 6){
                answer = "WED";
            } else if(days == 0){
                answer = "THU";
            }

            return answer;
        }
    }
}
