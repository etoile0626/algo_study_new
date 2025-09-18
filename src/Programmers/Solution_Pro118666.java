package Programmers;

public class Solution_Pro118666 {                       //성격 유형 검사하기
    class Solution {
        public String solution(String[] survey, int[] choices) {
            int len = survey.length;

            int rt = 0;
            int cf = 0;
            int jm = 0;
            int an = 0;

            for(int i = 0; i < len; i++){
                int score = 0;
                if(survey[i].equals("RT") || survey[i].equals("TR")){
                    score = choices[i] - 4;
                    if(survey[i].equals("TR")){
                        score *= -1;
                    }

                    rt += score;
                }
                else if(survey[i].equals("CF") || survey[i].equals("FC")){
                    score = choices[i] - 4;
                    if(survey[i].equals("FC")){
                        score *= -1;
                    }

                    cf += score;
                }
                else if(survey[i].equals("JM") || survey[i].equals("MJ")){
                    score = choices[i] - 4;
                    if(survey[i].equals("MJ")){
                        score *= -1;
                    }

                    jm += score;
                }
                else if(survey[i].equals("AN") || survey[i].equals("NA")){
                    score = choices[i] - 4;
                    if(survey[i].equals("NA")){
                        score *= -1;
                    }

                    an += score;
                }
            }

            String answer = "";

            if(rt > 0){
                answer += "T";
            } else{
                answer += "R";
            }

            if(cf > 0){
                answer += "F";
            } else{
                answer += "C";
            }

            if(jm > 0){
                answer += "M";
            } else{
                answer += "J";
            }

            if(an > 0){
                answer += "N";
            } else{
                answer += "A";
            }

            return answer;
        }
    }
}
